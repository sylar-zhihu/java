package MCLog.clean

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import MCLog.clean.oneStep.Step_1_OneLine

/**
  * 用途:日志清洗
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54
  */
object CleanLog {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sparkContext: SparkContext = sparkSession.sparkContext
    // 读取RDD
    val rawRDD: RDD[String] = sparkContext.textFile("C://data//log_100000.lee")

//    rawRDD.take(10).foreach(println(_: String))

    // 日志解析
    val cleanLog: RDD[Any] = rawRDD.map((line: String) => {
      try {
        Step_1_OneLine.cleanLog(line)
      } catch {
        case e: Exception => {
          println(e)
        }
      }

    })

    // 别人下次 也能使用
    cleanLog.saveAsTextFile("C://data//log_100000.clean")
  }
}