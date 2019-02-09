package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, rdd}

/**
  * @author asus
  *         Merge the values for each key using an associative function and a neutral "zero value" which
  *         may be added to the result an arbitrary number of times, and must not change the result
  *         (e.g., Nil for list concatenation, 0 for addition, or 1 for multiplication.).
  */
object FoldByKey_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd1: RDD[(Int, Int)] = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 3)
    //
    val rdd2: RDD[(Int, Int)] = rdd1.foldByKey(0)(_ + _)
    rdd2.collect()
    println(rdd2.collect().toBuffer)

  }
}
