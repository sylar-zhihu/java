package SPARK_SQL.dataSource

import org.apache.spark.sql.SparkSession

/**
  * 用途：创建sparkSession
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object ReadWindowsFile {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    //通过spark.read操作读取JSON数据


    val df = sparkSession.read.json("C://call.log")
    // 显示
    df.show()
    // 关闭
    sparkSession.stop()

  }

}
