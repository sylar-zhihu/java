package SPARK_SQL.sql

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：DataFrame 使用sql
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object SparkSql_3_Globle_Table2 {

  def main(args: Array[String]): Unit = {

    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()


    // 使用新的session还是可以查询
    sparkSession.newSession().sql("SELECT * FROM global_temp.people").show()
  }

}
