package Spark_Core.fuc.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author asus
 * 返回一个新的RDD，该RDD由每一个输入元素经过func函数转换后组成
 */
object RDD_Reduce {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc = new SparkContext(conf)
    // reduce(func)是对数据集的所有元素执行聚集(func)函数，该函数必须是可交换的。
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    // 返回的不是rdd
    val rdd2: Int = rdd1.reduce(_ + _)
    println(rdd2)// 45

  }
}
