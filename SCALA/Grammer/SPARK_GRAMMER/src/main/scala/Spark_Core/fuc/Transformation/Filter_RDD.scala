package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         返回一个新的RDD，该RDD由经过func函数计算后返回值为true的输入元素组成
  */
object Filter_RDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rdd2: RDD[Int] = sc.parallelize(1 to 15, 3)
    // Filter是对RDD元素进行过滤；返回一个新的数据集，是经过func函数后返回值为true的原元素组成；
    val rdd3: RDD[Int] = rdd2.filter(x => x > 10)
    rdd3.collect() // Array[Int] = Array(11, 12, 13, 14, 15)
    println(rdd3.collect().toBuffer) // 10-15
  }
}
