package SPARK_SQL.dataFrame.fuc

import org.apache.spark.sql.{DataFrame, SparkSession}

/**
  * 用途:DSL的全称是domain-specific language 操作
  * 实际上是把DataFrame转化成RDD，使用RDD的函数
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object DataFrameFunction3_Select {

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
    val peopleDF: DataFrame = sparkSession.read.json("C://employees.json")
    // 显示 输出前30 默认是20 不截取
    peopleDF.show(30, false)

    // printSchema
    peopleDF.printSchema()


    // 加入隐式转化 调用的是RDD的操作
    import sparkSession.implicits._
    // 赛选出所有列都为非空数据
    val noNull=peopleDF.na.drop()
    noNull.show()
    // 删除某一列为空的
    println("nameNotNull========== ")
    val nameNotNull=peopleDF.na.drop(Array("name"))
    nameNotNull.show()
    println("salaryNotNull================ ")
    val salaryNotNull=peopleDF.na.drop(Array("salary"))
    salaryNotNull.show()
    // 删除某一列为""

  }

}
