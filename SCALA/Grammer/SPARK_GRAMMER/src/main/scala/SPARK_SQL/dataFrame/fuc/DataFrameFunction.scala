package SPARK_SQL.dataFrame.fuc

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

/**
  * 用途:DSL的全称是domain-specific language 操作
  * 实际上是把DataFrame转化成RDD，使用RDD的函数
  * 作者：sylar-lee
  * 日期:2019/1/29 12:31
  */
object DataFrameFunction {

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
    // 得到前10个
    //    df.take(10)
    // 得到前10个
    //    df.head(10)
    // printSchema
    peopleDF.printSchema()
    // 显示某一列
    peopleDF.select("name").show()
    // 加入隐式转化 调用的是RDD的操作
    import sparkSession.implicits._
    // select 选择数据 改名要全部加$ 一旦改名，后面的操作也全部要用修改的名字
    peopleDF.select($"name", ($"salary" + 1).as("salaryFinal")).show()
    // 过滤数据 实际上用的是RDD函数，需要转换
    peopleDF.filter($"salary" > 3000).show()
    // 过滤 多条件  &&表示and
    peopleDF.filter("name='Andy' OR name='my'").filter($"salary" > 3000).show()
    peopleDF.filter($"name" === "Andy" || $"name" === "my").show()

  }

}
