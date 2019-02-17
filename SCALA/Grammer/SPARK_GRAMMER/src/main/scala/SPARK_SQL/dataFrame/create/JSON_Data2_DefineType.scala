package SPARK_SQL.dataFrame.create

import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：创建sparkSession
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  * 自定义数据类型
  */
object JSON_Data2_DefineType {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      .getOrCreate()
    //通过spark.read操作读取JSON数据 自动获取数据类型

    val employeesSchema = StructType(List(
      StructField("name", StringType, true),
      StructField("salary", StringType, true)
    ))

    val df = sparkSession.read.schema(employeesSchema).json("C://employees.json")

    // 显示
    df.show()
    // 会自动推断类型
    df.printSchema()

    // 关闭
    sparkSession.stop()

  }

}
