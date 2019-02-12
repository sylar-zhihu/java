package SPARK_SQL.dataSet

import org.apache
import org.apache.spark
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
  * 用途: Dataset 变成 DataFrame
  * 作者：sylar-lee
  * 日期:2019/1/29 13:46
  */
object DataSetToDF {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    import sparkSession.implicits._
    val lines: Dataset[String] = sparkSession.createDataset(List("1,lu,man", "2,wang,woman", "3,li,woman"))
    //对数据进行整理

    val tpDs: Dataset[(Long, String, String)] = lines.map((line: String) => {
      val segs = line.split(",")
      val id = segs(0).toLong
      val name = segs(1)
      val sex = segs(2)
      (id, name, sex)
    })
    val df1: DataFrame = tpDs.toDF("id", "name", "sex")
    df1.show()
  }

}
