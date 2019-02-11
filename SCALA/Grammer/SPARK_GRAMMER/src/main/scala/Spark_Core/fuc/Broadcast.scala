package Spark_Core.fuc

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * 用途:把变量发送到worker端
  * 作者：ljb
  * 日期:2019/2/11 19:09 
  */
object Broadcast {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    // collect是将数据集中的所有元素以一个array的形式返回。单个数据无法使用
    val rdd1: RDD[Int] = sc.parallelize(1 to 9, 3)
    //调用sc上的广播方法
    //广播变量的引用（还在Driver端）
    val broadcastRef: Broadcast[RDD[Int]] = sc.broadcast(rdd1)

  }

}
