package SPARK_SQL

import org.apache.spark.sql.types.{IntegerType, StringType, StructField}
import org.apache.spark.sql.{Row, SparkSession, types}

/**
  * 用途:把RDD转换成DF
  * 提前不知道数据类型使用structType
  * 作者：sylar-lee
  * 日期:2019/1/29 13:31
  */
object RDDToDFStructType {

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
    val rawRDD = sparkContext.textFile("hdfs://hadoop01:9000/people.txt")
    // 加入隐式转化
    // 把RDD 变成DF
    // 定义structType
    val peopleRDD = rawRDD.map(_.split(",")).map(line => (Row(line(0), line(1).trim().toInt)))
    val structType=types.StructType(Array(
      // 能否为空
      StructField("name",StringType,true),
      StructField("age",IntegerType,true)
    ))

    val peopleDF=sparkSession.createDataFrame(peopleRDD,structType)
    peopleDF.show()

  }


}
