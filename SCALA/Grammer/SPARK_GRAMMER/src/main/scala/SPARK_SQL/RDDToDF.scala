package SPARK_SQL

import org.apache.spark.sql.SparkSession

/**
  * 用途:把RDD转换成DF
  * 作者：sylar-lee
  * 日期:2019/1/29 13:31
  */
object RDDToDF {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sparkContext = sparkSession.sparkContext
    // 读取RDD
    val rawRDD = sparkContext.textFile("C://log_100000.txt")



    // 加入隐式转化
    import sparkSession.implicits._
    // 把RDD 变成DF
    val peopleDF = rawRDD.map(_.split(",")).map(line => (Persopn(line(0), line(1).trim().toInt))).toDF()
    peopleDF.show()

  }

  case class Persopn(name: String, age: Int)

}
