package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  * 针对于(K,V)形式的类型只对V进行操作
  */
object RDD_MapValues {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    val rdd3: RDD[(Int, String)] = sc.parallelize(Array((1,"a"),(1,"d"),(2,"b"),(3,"c")))
    val tuples: Array[(Int, String)] = rdd3.mapValues(_+"|||").collect()


  }
}
