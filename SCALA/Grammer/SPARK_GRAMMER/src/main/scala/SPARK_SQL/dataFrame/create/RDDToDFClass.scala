package SPARK_SQL.dataFrame.create

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途:把RDD转换成DF 使用class
  * 作者：sylar-lee
  * 日期:2019/1/29 13:31
  */
object RDDToDFClass {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sc = sparkSession.sparkContext
    // 得到RDD
    val data: Array[String] = Array("1 li 95 man", "2 wang 88 woman")
    // 并行化生成rdd 分区数量
    val rdd1: RDD[String] = sc.parallelize(data, 3)


    // 把RDD 变成DF
    val peopleRDD: RDD[Person] = rdd1.map(_.split(" ")).map((line: Array[String]) => {
      Person(line(0).toInt, line(1), line(2).toInt, line(3))
    })

    // 加入隐式转化
    import sparkSession.implicits._
    val peopleDF: DataFrame = peopleRDD.toDF()
    peopleDF.show()

  }

  case class Person(id: Int, name: String, age: Int, sex: String)

}
