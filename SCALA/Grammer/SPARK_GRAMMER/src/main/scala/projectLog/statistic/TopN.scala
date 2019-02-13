package projectLog.statistic

import org.apache.spark.sql.functions.count
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/30 18:48
  */
object TopN {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[1]")
      .appName("Spark SQL basic example")
      // 读取的时候不自动推断数据类型
      .config("spark.sql.sources.partitionColumnTypeInference.enabled","false")
      .getOrCreate()
    // 得到sparkContext
    // 读取json
    val logDF = sparkSession.read.json("C://log")
    logDF.show()

    videoAccessTopNStat(sparkSession,logDF,"20170511")
  }

  def videoAccessTopNStat(spark: SparkSession, accessDF:DataFrame, day:String): Unit = {
    import spark.implicits._

    val videoAccessTopNDF = accessDF.filter($"day" === day && $"cmsType" === "video")
      .groupBy("day","cmsId").agg(count("cmsId").as("times")).orderBy($"times".desc)

    videoAccessTopNDF.show(false)
  }

}
