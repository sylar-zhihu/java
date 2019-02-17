package SPARK_SQL.dataFrame.create

import org.apache.spark.sql.SparkSession

/**
  * 用途：创建sparkSession
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  * 所有的读取类型都看作是String
  */
object JSON_Data4_twoLevel {

  def main(args: Array[String]): Unit = {
    //创建sparkSession()并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      .getOrCreate()


    val df = sparkSession.read.option("primitivesAsString", "true").json("C:\\data\\employees2.json")

    // 显示
    df.show()
    // 会自动推断类型
    df.printSchema()
    // 得到某一个列
    df.select("name.name1").show()

    // 关闭
    sparkSession.stop()

  }

}
