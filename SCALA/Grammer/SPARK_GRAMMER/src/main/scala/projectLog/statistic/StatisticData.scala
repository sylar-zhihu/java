package projectLog.statistic

import org.apache.spark
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import projectLog.statistic.oneStep.Step_1_getData

/**
  * 用途: 对新的日志进行清洗
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54
  */
object StatisticData {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[*]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sparkContext: SparkContext = sparkSession.sparkContext
    // 读取RDD
    val rawRDD: RDD[String] = sparkContext.textFile("C://data//access2.lee")

    rawRDD.take(10).foreach(println(_))
    // toDF
    val dataDF = sparkSession.createDataFrame(rawRDD.map(x => Step_1_getData.parseLog(x)),
      Step_1_getData.struct)

    dataDF.printSchema()
    dataDF.show(false)

    println("down")
  }

}
