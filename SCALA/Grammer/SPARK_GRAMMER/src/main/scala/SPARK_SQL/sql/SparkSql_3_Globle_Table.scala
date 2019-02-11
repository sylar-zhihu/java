package SPARK_SQL.sql

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：DataFrame 使用sql
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object SparkSql_3_Globle_Table {

  def main(args: Array[String]): Unit = {

    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    //通过spark.read操作读取JSON数据
    val df: DataFrame = sparkSession.read.json("hdfs://hadoop01:9000/employees.json")

    // 临时表是Session范围内的，Session退出后，表就失效了。
    // 如果想应用范围内有效，可以使用全局表。注意使用全局表时需要全路径访问，
    // 如：global_temp.people
    df.createGlobalTempView("people")
    sparkSession.sql("SELECT * FROM global_temp.people").show()
    // 使用新的session还是可以查询
    sparkSession.newSession().sql("SELECT * FROM global_temp.people").show()
  }

}
