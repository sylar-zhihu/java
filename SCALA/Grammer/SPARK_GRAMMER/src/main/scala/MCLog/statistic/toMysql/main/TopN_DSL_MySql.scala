package MCLog.statistic.toMysql.main

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{count, row_number, sum}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import MCLog.statistic.toMysql.{City_Statistic, CmsID_Statistic, SDAO, Traffics_Statistic}

import scala.collection.mutable.ListBuffer

/**
  * 用途:把数据写入mysql
  * 作者：sylar-lee
  * 日期:2019/1/30 18:48
  */
object TopN_DSL_MySql {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[1]")
      .appName("Spark SQL basic example")
      // 读取的时候不自动推断数据类型 不然day会当成int类型
      .config("spark.sql.sources.partitionColumnTypeInference.enabled", "false")
      .getOrCreate()
    // 得到sparkContext
    // 读取json
    val logDF: DataFrame = sparkSession.read.format("parquet").load("C://data//logs/clean")
    logDF.show()
    println(logDF.schema)

    // 统计 video cmsID 每天的访问次数
//    videoAccessTopNStat(sparkSession, logDF, "20170511", "video")
    //按照地市进行统计TopN课程
//    cityAccessTopNStat(sparkSession, logDF, day="20170511")
    //按照流量进行统计
//    videoTrafficsTopNStat(sparkSession, logDF, day="20170511")
    // delete
    SDAO.deleteData("city_statistic",day="20170511")

  }

  def videoAccessTopNStat(spark: SparkSession, accessDF: DataFrame, day: String, courseType: String): Unit = {

    import spark.implicits._
    val videoAccessTopNDF: Dataset[Row] = accessDF.select($"day", $"cmsType", $"cmsId")
      .filter($"day" === day && $"cmsType" === courseType)
      .groupBy("day", "cmsId").agg(count("cmsId").as("times")).orderBy($"times".desc)


    try {
      videoAccessTopNDF.foreachPartition(partitionOfRecords => {
        val list = new ListBuffer[CmsID_Statistic]

        partitionOfRecords.foreach(info => {
          val day = info.getAs[String]("day")
          val cmsId = info.getAs[Long]("cmsId")
          val times = info.getAs[Long]("times")

          list.append(CmsID_Statistic(day, cmsId, times))
        })

        SDAO.insertDayVideoAccessTopN(list)
      })
    } catch {
      case e: Exception => e.printStackTrace()
    }

  }

  /**
    * 按照地市进行统计TopN课程
    */
  def cityAccessTopNStat(spark: SparkSession, accessDF:DataFrame, day:String): Unit = {
    import spark.implicits._

    val cityAccessTopNDF = accessDF.filter($"day" === day && $"cmsType" === "video")
      .groupBy("day","city","cmsId")
      .agg(count("cmsId").as("times"))

    //cityAccessTopNDF.show(false)

    //Window函数在Spark SQL的使用
    /*
    row_number sql中的用于给数据库表中的记录进行标号，
    在使用的时候，其后还跟着一个函数 over()，而函数 over() 的作用是将表中的记录进行分组和排序。
    两者使用的语法为：
    ROW_NUMBER() OVER(PARTITION BY COLUMN1 ORDER BY COLUMN2)
     */

    val top3DF = cityAccessTopNDF.select(
      cityAccessTopNDF("day"),
      cityAccessTopNDF("city"),
      cityAccessTopNDF("cmsId"),
      cityAccessTopNDF("times"),
      row_number().over(Window.partitionBy(cityAccessTopNDF("city"))
        .orderBy(cityAccessTopNDF("times").desc)
      ).as("times_rank")
    ).filter("times_rank <=3") //.show(false)  //Top3


    /**
      * 将统计结果写入到MySQL中
      */
    try {
      top3DF.foreachPartition(partitionOfRecords => {
        val list = new ListBuffer[City_Statistic]

        partitionOfRecords.foreach(info => {
          val day = info.getAs[String]("day")
          val cmsId = info.getAs[Long]("cmsId")
          val city = info.getAs[String]("city")
          val times = info.getAs[Long]("times")
          val timesRank = info.getAs[Int]("times_rank")
          list.append(City_Statistic(day, cmsId, city, times, timesRank))
        })

        SDAO.insertDayCityVideoAccessTopN(list)
      })
    } catch {
      case e:Exception => e.printStackTrace()
    }

  }

  /**
    * 按照流量进行统计
    */
  def videoTrafficsTopNStat(spark: SparkSession, accessDF:DataFrame, day:String): Unit = {
    import spark.implicits._

    val cityAccessTopNDF = accessDF.filter($"day" === day && $"cmsType" === "video")
      .groupBy("day","cmsId").agg(sum("traffic").as("traffics"))
      .orderBy($"traffics".desc)
    //.show(false)

    /**
      * 将统计结果写入到MySQL中
      */
    try {
      cityAccessTopNDF.foreachPartition(partitionOfRecords => {
        val list = new ListBuffer[Traffics_Statistic]

        partitionOfRecords.foreach(info => {
          val day = info.getAs[String]("day")
          val cmsId = info.getAs[Long]("cmsId")
          val traffics = info.getAs[Long]("traffics")
          list.append(Traffics_Statistic(day, cmsId,traffics))
        })

        SDAO.insertDayVideoTrafficsAccessTopN(list)
      })
    } catch {
      case e:Exception => e.printStackTrace()
    }

  }
}
