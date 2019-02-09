package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext, rdd}

/**
  * @author asus
  *         排序 在一个(K,V)的RDD上调用，
  *         K必须实现Ordered接口，返回一个按照key进行排序的(K,V)的RDD
  */
object SortByKey_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd1: RDD[(Int, String)] = sc.parallelize(Array((3, "aa"), (6, "cc"), (2, "bb"), (1, "dd")))
    // 排序 升序
    val rdd2: RDD[(Int, String)] = rdd1.sortByKey(false)
    println(rdd2.collect().toBuffer) // ArrayBuffer((6,cc), (3,aa), (2,bb), (1,dd))
  }
}
