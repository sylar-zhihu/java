package Spark_Core.fuc.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author asus
 * 取出RDD中的前N个元素
 */
object RDD_Take {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    // collect是将数据集中的所有元素以一个array的形式返回。单个数据无法使用
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    val ints: Array[Int] = rdd1.take(2)
    println(ints.toBuffer)

  }
}
