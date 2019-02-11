package SPARK_SQL.dataFrame.create

import org.apache.spark
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
  * 用途：创建sparkSession
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object HDFS_txt {

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
    // 注册视图
    words.createTempView("words")

    //执行SQL（Transformation，lazy）
    val result: DataFrame = sparkSession.sql("SELECT value, COUNT(*) counts FROM words GROUP BY value ORDER BY counts DESC")

    //执行Action
    result.show()

    // 关闭
    sparkSession.stop()

  }

}
