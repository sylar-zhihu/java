package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         必须是key:value类型
  *         对RDD进行分区操作
  */
object RDD_PartitionBy {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)
    val rdd1: RDD[(Int, String)] = sc.parallelize(Array((1,"aaa"),(2,"bbb"),(3,"ccc"),(4,"ddd")),4)
    // 输出分区数量
    rdd1.partitions.size// 4
    var rdd2 = rdd1.partitionBy(new org.apache.spark.HashPartitioner(2))
    // 输出分区数量
    rdd2.partitions.size// 2



  }
}
