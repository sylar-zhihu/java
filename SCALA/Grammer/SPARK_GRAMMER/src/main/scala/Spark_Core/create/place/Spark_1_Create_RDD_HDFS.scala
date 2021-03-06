package Spark_Core.create.place

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 用途:只能读取文件 其他类型如json.生成的不是RDD
  * 作者：ljb
  * 日期:2019/2/16 19:52 
  */
object Spark_1_Create_RDD_HDFS {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)
    // 设置日志等级
    Logger.getRootLogger.setLevel(Level.WARN)
    // 2）由外部存储系统的数据集创建，HDFS数据
    val rdd2 = sc.textFile("hdfs://hadoop01:9000/a.txt")
    rdd2.collect()
    // 关闭连接
    sc.stop()
  }
}
