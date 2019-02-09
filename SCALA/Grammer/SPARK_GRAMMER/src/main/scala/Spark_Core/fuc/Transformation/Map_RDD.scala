package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  * 返回一个新的RDD，该RDD由每一个输入元素经过map(func)函数转换后组成
  */
object Map_RDD {
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
