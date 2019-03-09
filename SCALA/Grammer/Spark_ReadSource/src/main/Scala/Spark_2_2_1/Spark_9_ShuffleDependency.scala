package Spark_2_2_1

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_9_ShuffleDependency {

  def main(args: Array[String]): Unit = {
    // ShuffleDependency
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)

    // 1）由一个已经存在的Scala集合创建RDD
    val data: Array[(String, Int)] = Array(("a",1), ("b",2), ("a",2))
    // 并行化生成rdd 分区数量
    val rdd1: RDD[(String, Int)] = sc.parallelize(data, 3)
    // ShuffleDependency
    val rdd3: RDD[(String, Int)] = rdd1.reduceByKey(_+_)
    println(rdd3.collect().toBuffer)
    println(rdd3.partitions.size)
    println(rdd3.collect().toBuffer)

  }
}
