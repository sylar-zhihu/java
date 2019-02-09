package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         对相同K，把V合并成一个集合.
  *         createCombiner: combineByKey() 会遍历分区中的所有元素，
  *         因此每个元素的键要么还没有遇到过，要么就 和之前的某个元素的键相同。
  *         如果这是一个新的元素,combineByKey() 会使用一个叫作 createCombiner() 的函数来创建
  *         那个键对应的累加器的初始值
  *         mergeValue: 如果这是一个在处理当前分区之前已经遇到的键，
  *         它会使用 mergeValue() 方法将该键的累加器对应的当前值与这个新的值进行合并
  *         mergeCombiners: 由于每个分区都是独立处理的， 因此对于同一个键可以有多个累加器。
  *         如果有两个或者更多的分区都有对应同一个键的累加器， 就需要使用用户提供的 mergeCombiners()
  *         方法将各个分区的结果进行合并。
  */
object CombineByKey_RDD {
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
