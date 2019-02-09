package Spark_Core.fuc.Transformation

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author asus
 * 数据合并,不会剔除相同元素
 */
object Union_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd2: RDD[Int] = sc.parallelize(List(1,2,3))
    val rdd3: RDD[Int] = sc.parallelize(List(2,3,4))

    val rdd4: RDD[Int] = rdd2.union(rdd3)
    rdd4.collect() // Array[Int] = Array(1, 2, 3, 2, 3, 4)
    val rdd5: RDD[Int] = rdd2.intersection(rdd3)
    rdd5.collect() // Array[Int] = Array(2,3)


  }
}
