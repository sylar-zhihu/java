package Spark_Core.create

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/2/4 14:45
  */
object Context_Conf {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val sparkConf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // sparkConf得到sparkContext
    val sparkContext: SparkContext = new SparkContext(sparkConf)
    // sparkContext得到conf
    val sparkConf2: SparkConf = sparkContext.getConf

  }
}
