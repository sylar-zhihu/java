package MCLog.statistic

import org.apache.spark.sql.functions.count
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/30 18:48
  */
object TopN_DSL {

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

    // 得到最多的N个
    videoAccessTopNStat(sparkSession, logDF, "20170511", "video")
  }

  def videoAccessTopNStat(spark: SparkSession, accessDF: DataFrame, day: String, courseType: String): Unit = {

    import spark.implicits._
    val videoAccessTopNDF: Dataset[Row] = accessDF.select($"day", $"cmsType", $"cmsID".as("CourseID"))
      .filter($"day" === day && $"cmsType" === courseType)
      .groupBy("day", "CourseID").agg(count("CourseID").as("times")).orderBy($"times".desc)

    videoAccessTopNDF.show(false)
  }

}
