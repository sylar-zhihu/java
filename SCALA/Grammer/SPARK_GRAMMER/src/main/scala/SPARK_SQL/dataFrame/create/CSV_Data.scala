package SPARK_SQL.dataFrame.create

import org.apache
import org.apache.spark
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：csv不常用
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object CSV_Data {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    //指定以后读取json类型的数据 最好带有表头
    val csv: DataFrame = sparkSession.read.format("csv")
      .option("header", "true").load("C:\\data\\sales.csv")

    // 都是String
    csv.printSchema()
    csv.show()

//    val pdf: DataFrame = csv.toDF("id", "name", "age")
//
//    pdf.show()

    sparkSession.stop()
  }

}
