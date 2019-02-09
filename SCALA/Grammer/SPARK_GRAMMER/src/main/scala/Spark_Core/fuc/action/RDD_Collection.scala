package Spark_Core.fuc.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author asus
 * 返回一个新的RDD，该RDD由每一个输入元素经过func函数转换后组成
 */
object RDD_Collection {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    // collect是将数据集中的所有元素以一个array的形式返回。单个数据无法使用
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    rdd1.collect()
    // 数组要tobuffer才能看到，不然是对象地址
    println(rdd1.collect().toBuffer)// 45

  }
}
