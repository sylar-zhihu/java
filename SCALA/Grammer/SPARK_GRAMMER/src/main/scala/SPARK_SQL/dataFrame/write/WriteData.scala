package SPARK_SQL.dataFrame.write

import java.util.Properties

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途：从jdbc读取数据
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object WriteData {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

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


    val props = new Properties()
    props.put("user","root")
    props.put("password","123")
    //
    logs.write.mode("ignore").jdbc("jdbc:mysql://localhost:3306/spark", "spark2", props)

    //DataFrame保存成text时出错(只能保存一列) 需要保存表头 所以不常用
    //reslut.write.text("/Users/zx/Desktop/text")

    //reslut.write.json("/Users/zx/Desktop/json")

    //reslut.write.csv("/Users/zx/Desktop/csv")

    //reslut.write.parquet("hdfs://node-4:9000/parquet")


    //reslut.show()


  }

}
