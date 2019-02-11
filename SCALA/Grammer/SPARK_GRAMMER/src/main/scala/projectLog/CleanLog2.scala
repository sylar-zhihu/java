package projectLog

import org.apache.spark.sql.SparkSession

/**
  * 用途: 对新的日志进行清洗
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54 
  */
object CleanLog2 {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[1]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sparkContext = sparkSession.sparkContext
    // 读取RDD
    val rawRDD = sparkContext.textFile("C://access.lee")
    // toDF

    val accessDF= sparkSession.createDataFrame(rawRDD.map(x=>LogUtil.parseLog(x)),LogUtil.struct)

    accessDF.coalesce(1).write.format("json").partitionBy("day").save("C://log")
    //    accessDF.printSchema()
//    accessDF.show(false)
//    accessDF.w


    println("down")
  }

}
