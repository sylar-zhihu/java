package SPARK_SQL.sql

import org.apache
import org.apache.spark
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
  * 用途：DataFrame 使用sql
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object SparkSql_4_Join {

  def main(args: Array[String]): Unit = {

    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    // 创建
    import sparkSession.implicits._
    val lines: Dataset[String] = sparkSession.createDataset(List("1,laozhoa,china", "2,laoduan,usa", "3,laoyang,jp"))
    //对数据进行整理

    val tpDs: Dataset[(Long, String, String)] = lines.map(line => {
      val fields = line.split(",")
      val id = fields(0).toLong
      val name = fields(1)
      val nationCode = fields(2)
      (id, name, nationCode)
    })
    val df1 = tpDs.toDF("id", "name", "nation")

    val nations: Dataset[String] = sparkSession.createDataset(List("china,中国", "usa,美国"))
    //对数据进行整理
    val ndataset: Dataset[(String, String)] = nations.map(l => {
      val fields = l.split(",")
      val ename = fields(0)
      val cname = fields(1)
      (ename, cname)
    })

    val df2 = ndataset.toDF("ename", "cname")

    df2.count()

    //第一种，创建视图
    df1.createTempView("v_users")
    df2.createTempView("v_nations")
    val r: DataFrame = sparkSession.sql("SELECT name, cname FROM v_users JOIN v_nations ON nation = ename")
    r.show()


    import org.apache.spark.sql.functions._
    val r2 = df1.join(df2, $"nation" === $"ename", "left_outer")
    r2.show()

  }

}
