package SPARK_SQL.dataFrame.create

import org.apache.spark
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

/**
  * 用途：从jdbc读取数据
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object JDBC_Read {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    import sparkSession.implicits._

    // 读取表头数据 不触发action
    val logs: DataFrame = sparkSession.read.format("jdbc").options(
      Map("url" -> "jdbc:mysql://localhost:3306/spark",
        "driver" -> "com.mysql.jdbc.Driver",
        "dbtable" -> "spark1",
        "user" -> "root",
        "password" -> "123")
    ).load()

    logs.printSchema()

    logs.show()

    //    val filtered: Dataset[Row] = logs.filter(r => {
    //      r.getAs[Int]("age") <= 13
    //    })
    //    filtered.show()

    // lambda表达式
    val r: Dataset[Row] = logs.filter($"id" <= 3)
    // 效果一样
    //val r = logs.where($"age" <= 13)

    val reslut: DataFrame = r.select($"id", $"name", $"age" * 10 as "age")




  }

}
