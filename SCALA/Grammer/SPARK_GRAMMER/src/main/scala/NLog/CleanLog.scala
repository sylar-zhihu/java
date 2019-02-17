package NLog

import MCLog.clean.oneStep.Step_1_OneLine
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途:日志清洗
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54
  */
object CleanLog {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    //通过spark.read操作读取JSON数据 自动获取数据类型
    var df: DataFrame = sparkSession.read.json("C:\\data\\20170814new")
    // 显示  读取json 但是有两层嵌套
//    df.show(false)
   println(df.count())
    // 打印
    df.printSchema()
    // 选择header数据
    // df.select("header").show(false)
    // 去掉空值
    val nameNotNull=df.na.drop(Array("header.sdk_ver","header.time_zone","header.commit_id"
      ,"header.commit_time","header.pid","header.app_token","header.app_id","header.device_id"))
    import sparkSession.implicits._
    println(df.count())
//    df=df.filter("sdk_ver")

    //
    sparkSession.stop()
//    rawRDD.take(10).foreach(println(_: String))

//    // 日志解析
//    val cleanLog: RDD[Any] = rawRDD.map((line: String) => {
//      try {
//        Step_1_OneLine.cleanLog(line)
//      } catch {
//        case e: Exception => {
//          println(e)
//        }
//      }
//
//    })
//
//    // 别人下次 也能使用
//    cleanLog.saveAsTextFile("C://data//log_100000.clean")
  }
}