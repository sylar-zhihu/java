package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author asus
 * 排序 Return this RDD sorted by the given key function.
 */
object SortBy_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    // 排序 升序
    val rdd3: RDD[Int] =rdd1.sortBy(x => x ,true)
    println(rdd3.collect().toBuffer) // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }
}
