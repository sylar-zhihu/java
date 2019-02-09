package SPARK_SQL

import org.apache.spark.sql.SparkSession

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/29 13:46 
  */
object SparkDataSet {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 通过隐式转换将RDD操作添加到DataFrame上
    case class Person(name: String, age: Long)
    // Encoders are created for case classes
//    val caseClassDS = Seq(Person("Andy", 32)).toDS()
//    caseClassDS.show()

  }

}
