package SPARK_SQL.sql

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：使用新的session会报错
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object SparkSql_2_TableError {

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
    // 转化为临时表
    df.createOrReplaceTempView("people")
    // 使用sql去查询表
    val sqlDF: DataFrame = sparkSession.sql("SELECT * FROM people")
    sqlDF.show()
    // 使用新的session去查询 报错表不存在
    sparkSession.newSession().sql("SELECT * FROM people").show()


  }

}
