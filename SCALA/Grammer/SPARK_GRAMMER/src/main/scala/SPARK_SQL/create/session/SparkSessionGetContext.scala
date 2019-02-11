package SPARK_SQL.create.session

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

/**
  * 用途：通过sparkSession得到SparkContext
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object SparkSessionGetContext {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()


    // 内置SparkContext
    val sc: SparkContext = sparkSession.sparkContext
    sparkSession.stop()

  }

}
