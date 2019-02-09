package Spark_Core.create

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_1_Create_RDDFromScala {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD_Scala").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)
    // 设置日志等级
    Logger.getRootLogger.setLevel(Level.WARN)
    // 1）由一个已经存在的Scala集合创建RDD
    val data: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8)
    // 并行化生成rdd 分区数量
    val rdd1: RDD[Int] = sc.parallelize(data, 3)
    // 执行action操作
    println(rdd1.collect().toBuffer)
    sc.stop()
  }
}
