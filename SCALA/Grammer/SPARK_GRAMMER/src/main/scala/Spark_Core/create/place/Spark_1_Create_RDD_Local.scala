package Spark_Core.create.place

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 用途:
  * 作者：ljb
  * 日期:2019/2/16 19:52 
  */
object Spark_1_Create_RDD_Local {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)
    // 设置日志等级
    Logger.getRootLogger.setLevel(Level.WARN)


    // 读取本地数据 windows
    val rdd2: RDD[String] = sc.textFile("C://a.txt")
    //  读取linux 使用集群用不了读取本地 因为集群上的机器没有这个文件夹
    //  var rdd2= sc.textFile("file:///root/a.txt")
    println(rdd2.collect().toBuffer)
    // 关闭连接
    sc.stop()
  }
}
