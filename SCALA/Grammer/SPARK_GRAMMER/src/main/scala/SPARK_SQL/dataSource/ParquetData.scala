package SPARK_SQL.dataSource

import org.apache.spark.sql.SparkSession

/**
  * 用途:读取parquet数据
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object ParquetData {

  def main(args: Array[String]): Unit = {

    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 通过隐式转换将RDD操作添加到DataFrame上
    // 通过spark.read读取JSON数据 转成为DF
    val df = sparkSession.read.parquet("hdfs://hadoop01:9000/sparkData/users.parquet")
    // 显示 输出前20
    df.show()
    // printSchema
    df.printSchema()
    // 写数据
    val writeDF = df.select("name")
    // 传入的数据是一个目录
    writeDF.write.format("json").save("hdfs://hadoop01:9000/sparkOut")
  }

}
