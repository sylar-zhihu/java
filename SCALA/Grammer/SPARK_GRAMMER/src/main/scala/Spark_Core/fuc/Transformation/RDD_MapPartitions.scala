package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  * 类似于map，但独立地在RDD的每一个分片上运行，因此在类型为T的RDD上运行时
  * func的函数类型必须是Iterator[T] => Iterator[U]。
  * 假设有N个元素，有M个分区，那么map的函数的将被调用N次,
  * 而mapPartitions被调用M次,一个函数一次处理所有分区
  */
object RDD_MapPartitions {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    // 每个数字都乘上2
    val rdd2: RDD[Int] = rdd1.map(x => x * 2)
    rdd2.collect()// Array[Int] = Array(2, 4, 6, 8, 10, 12, 14, 16, 18)
    // 另一种写法
    val rdd3: RDD[Int] = rdd1.map(_* 2)
    rdd3.collect()
    println(rdd2.collect().toBuffer)

  }
}
