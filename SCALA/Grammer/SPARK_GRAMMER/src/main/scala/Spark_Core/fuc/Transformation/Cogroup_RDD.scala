package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         在类型为(K,V)和(K,W)的RDD上调用，返回一个(K,(Iterable<V>,Iterable<W>))类型的RDD
  *         For each key k in `this` or `other`, return a resulting RDD that contains a tuple with the
  *         list of values for that key in `this` as well as `other`.
  */
object Cogroup_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)

    val rdd = sc.parallelize(Array((1,"a"),(2,"b"),(3,"c")))

    val rdd1 = sc.parallelize(Array((1,4),(2,5),(3,6)))

    val rdd3: Array[(Int, (Iterable[String], Iterable[Int]))] = rdd.cogroup(rdd1).collect()
    println(rdd3.toBuffer)
  }
}
