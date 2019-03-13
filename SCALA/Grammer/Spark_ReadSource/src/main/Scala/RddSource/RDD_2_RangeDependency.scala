package RddSource

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 用途:
  * 作者：ljb
  * 日期:2019/3/10 11:01 
  */
object RDD_2_RangeDependency {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)

    // 1）由一个已经存在的Scala集合创建RDD
    val data: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8)
    // 并行化生成rdd 分区数量
    val rdd1: RDD[Int] = sc.parallelize(data, 2)
    // 调用map 新生成一个RDD
    val rdd2: RDD[Int] = sc.parallelize(data, 2)
    val rdd3: RDD[Int] = rdd1.union(rdd2)
    println(rdd3.collect().toBuffer)
    println(rdd3.partitions.size)// 4
    println(rdd3.collect().toBuffer)

  }
}
