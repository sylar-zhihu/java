package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         在kv对的RDD中，，按key将value进行分组合并，合并时，将每个value和初始值作为seq函数的参数，进行计算，返回的结果作为一个新的kv对，然后再将结果按照key进行合并，最后将每个分组的value传递给combine函数进行计算（先将前两个value进行计算，将返回结果和下一个value传给combine函数，以此类推），将key与计算结果作为一个新的kv对输出。
  *         seqOp函数用于在每一个分区中用初始值逐步迭代value，combOp函数用于合并每个分区中的结果
  */
object AggregateByKey_RDD {
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
