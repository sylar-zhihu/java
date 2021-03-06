package Spark_Core.fuc.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         在一个(K,V)的RDD上调用，返回一个(K,V)的RDD，使用指定的reduce函数，
  *         将相同key的值聚合到一起，reduce任务的个数可以通过第二个可选的参数来设置
  *         先会在分区聚合
  */
object ReduceByKey_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc = new SparkContext(conf)
    // reduce(func)是对数据集的所有元素执行聚集(func)函数，该函数必须是可交换的。
    val rdd: RDD[(String, Int)] = sc.parallelize(List(("a", 2), ("b", 3), ("a", 3)))
    // 合并key计算 x,y是两个不同元祖的value
    val r1: RDD[(String, Int)] = rdd.reduceByKey((x, y) => x + y)
    // 简写就是
    val r2: RDD[(String, Int)] = rdd.reduceByKey(_ + _)
    println(r1.collect().toBuffer) // ArrayBuffer((a,5), (b,3))

  }
}
