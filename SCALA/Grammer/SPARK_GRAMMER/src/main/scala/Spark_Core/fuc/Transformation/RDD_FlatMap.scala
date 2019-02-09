package Spark_Core.fuc.Transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         类似于map，但是每一个输入元素可以被映射为0或多个输出元素（所以func应该返回一个序列，而不是单一元素）
  */
object RDD_FlatMap {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd2: RDD[String] = sc.parallelize(Array("a b c", "c t h"))
    rdd2.collect()
    // flatMap类似于map，输入的必须是集合，会把集合里面的每一个元素，做函数操作，把所有的结果汇总成一个list
    val rdd3: RDD[String] = rdd2.flatMap(_.split(" "))
    println(rdd3.collect().toBuffer) // Array(a, b, c, c, t, h)
    rdd3.collect()
    // 和map对比
    val rdd4: RDD[Array[String]] = rdd2.map(_.split(" "))
    println(rdd4) // Array[Array[String]] = Array(Array(a, b, c), Array(c, t, h))
    rdd4.collect()
    // 两层的flatMap
    val rdd5: RDD[List[String]] = sc.parallelize(List(List("a b c", "c t h"), List("a b c", "c t h")))
    rdd5.flatMap(_.flatMap(_.split(" ")))

  }
}
