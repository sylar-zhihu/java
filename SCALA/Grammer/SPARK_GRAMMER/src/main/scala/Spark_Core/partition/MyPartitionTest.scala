package Spark_Core.partition

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.{ SparkConf, SparkContext}

/**
  * 用途:使用自定义分区
  * 作者：sylar-lee
  * 日期:2019/2/7 10:37 
  */

/**
  * 自己写的自定义分区函数，继承spark的分区函数
  *
  * @param numParts
  */

object MyPartitionTest {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)
    // 原始数据
    val data: Seq[String] = List("aa.2", "bb.2", "cc.3", "dd.3", "ee.5")

    // 并行化生成rdd 分区数量
    val rdd1: RDD[String] = sc.parallelize(data, 3)
    val rdd2: RDD[(String, Int)] = rdd1.map((_, 1))
    // 查看分区数量
    println(rdd2.partitions.size) // 3
    // 查看分区器 默认是没有分区器的
    println(rdd2.partitioner) // Option[org.apache.spark.Partitioner] = None
    // 输出分区的数据
    val rdd2Show: Array[String] = rdd2.mapPartitionsWithIndex((index, iter) => Iterator(index.toString + " : " + iter.mkString("|"))).collect
    println(rdd2Show.toBuffer)
    // 重新分区
    val rdd3: RDD[(String, Int)] = rdd2.partitionBy(new MyPartition(5))

    // 查看分区数量
    println(rdd3.partitions.size) // 3
    // 查看分区器 默认是没有分区器的
    println( rdd3.partitioner )// Option[org.apache.spark.Partitioner] = None
    // 输出分区的数据
    val rdd4: Array[String] = rdd3.mapPartitionsWithIndex((index, iter) => Iterator(index.toString + " : " + iter.mkString("|"))).collect
    println(rdd4.toBuffer)
    sc.stop()
  }
}

