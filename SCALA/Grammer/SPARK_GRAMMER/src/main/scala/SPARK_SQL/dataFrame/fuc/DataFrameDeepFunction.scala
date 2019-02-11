package SPARK_SQL.dataFrame.fuc

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.count

/**
  * 用途:DataFrame的函数操作,
  * 实际上是把DataFrame转化成RDD，使用RDD的函数
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object DataFrameDeepFunction {

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
    // val df = sparkSession.read.json("hdfs://hadoop01:9000/a.json")
    val logsDF = sparkSession.read.json("C://logs.json")
    // 显示 输出前30 默认是20 不截取
    logsDF.show(30, false)
    // printSchema
    logsDF.printSchema()
    // 加入隐式转化 groupby需要手动引入包
    import sparkSession.implicits._
    //  统计城市为wuhan 不同cmsType 类型 访问次数最多的cmsID
    logsDF.filter($"city"==="wuhan")
      .groupBy("cmsID","cmsType").agg(count("cmsID").as("times")).orderBy($"times".desc).show()

  }

}
