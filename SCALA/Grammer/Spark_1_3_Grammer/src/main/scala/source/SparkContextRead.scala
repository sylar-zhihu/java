package source

import org.apache.spark.{SparkConf, SparkContext}

object SparkContextRead {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val sparkConf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // sparkConf得到sparkContext
    val sparkContext: SparkContext = new SparkContext(sparkConf)
    //  SparkContext.createTaskScheduler(this, master, deployMode)
    // 找到对应函数
    // private def createTaskScheduler

  }

}
