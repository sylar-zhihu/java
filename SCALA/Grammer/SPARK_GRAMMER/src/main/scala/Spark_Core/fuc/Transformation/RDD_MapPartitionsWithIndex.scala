package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         Return a new RDD by applying a function to each partition of this RDD, while tracking the index
  *         of the original partition.
  */
object RDD_MapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    // 对每个分区进行操作
    val rdd2: RDD[String] = rdd1.mapPartitionsWithIndex((index,iter)=>Iterator(index.toString+":"+iter.mkString(",")))
    rdd2.collect() //  Array[String] = Array(0:1,2,3, 1:4,5,6, 2:7,8,9)

  }
}
