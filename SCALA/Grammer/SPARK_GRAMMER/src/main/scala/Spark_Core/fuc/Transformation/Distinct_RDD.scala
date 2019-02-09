package Spark_Core.fuc.Transformation

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  *         去重
  */
object Distinct_RDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("RDD_Filter").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rdd2 = sc.parallelize(List(1, 5, 6, 7))
    val rdd3 = sc.parallelize(List(1, 5, 6, 8))

    var rdd4 = rdd2.union(rdd3)
    // 去重
    rdd4 = rdd4.distinct()
    println(rdd4.collect().toBuffer) // (8, 1, 5, 6, 7)
  }
}
