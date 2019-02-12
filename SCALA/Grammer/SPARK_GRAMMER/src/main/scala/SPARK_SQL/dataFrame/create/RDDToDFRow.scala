package SPARK_SQL.dataFrame.create

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession, types}

/**
  * 用途:把RDD转换成DF 使用Row
  * 作者：sylar-lee
  * 日期:2019/1/29 13:31
  */
object RDDToDFRow {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sc: SparkContext = sparkSession.sparkContext
    // 得到RDD
    val data: Array[String] = Array("1 li 95 man", "2 wang 88 woman")
    // 并行化生成rdd 分区数量
    val rdd1: RDD[String] = sc.parallelize(data, 3)

    // 把RDD 变成Row
    val peopleRDD: RDD[Row] = rdd1.map(_.split(" ")).map((line: Array[String]) => {
      Row(line(0).toInt, line(1), line(2).toInt, line(3))
    })

    // 对表的描述
    val schema = StructType(List(
      // true 能否为空
      StructField("id", IntegerType, true),
      StructField("name", StringType, true),
      StructField("age", IntegerType, true),
      StructField("sex", StringType, true)
    ))

    // 把row对象和schema 关联
    val peopleDF: DataFrame =sparkSession.createDataFrame(peopleRDD,schema)
    peopleDF.show()





  }

}
