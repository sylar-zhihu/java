package SPARK_SQL.dataFrame.create

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：创建sparkSession
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  * 若列数据全为null会用String类型
  * 整数默认会用Long类型
  * 浮点数默认会用Double类型
  */
object JSON_Data {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      .getOrCreate()
    //通过spark.read操作读取JSON数据 自动获取数据类型
    val df: DataFrame = sparkSession.read.json("C://employees.json")
    // 显示
    df.show()
    // 会自动推断类型
    df.printSchema()

    // 关闭
    sparkSession.stop()

  }

}
