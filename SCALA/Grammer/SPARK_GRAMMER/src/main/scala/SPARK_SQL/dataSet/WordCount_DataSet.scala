package SPARK_SQL.dataSet

import org.apache
import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  * 用途：sql的wordCount
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object WordCount_DataSet {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 当做普通文件来读 读取的数据只有一列
    val lines: Dataset[String] = sparkSession.read.textFile("hdfs://hadoop01:9000/words.txt")
    // 显示
    lines.show()
    import sparkSession.implicits._
    // 转化成表
    val words: Dataset[String] = lines.flatMap(_.split(" "))
    //使用DataSet的API（DSL）

    //导入聚合函数
    import org.apache.spark.sql.functions._
    val counts: Dataset[Row] = words.groupBy($"value" as "word").agg(count("*") as "counts").orderBy($"counts" desc)

    counts.show()


  }

}
