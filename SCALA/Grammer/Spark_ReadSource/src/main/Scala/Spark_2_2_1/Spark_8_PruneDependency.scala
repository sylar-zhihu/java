package Spark_2_2_1

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark_8_PruneDependency {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)

    // 1）由一个已经存在的Scala集合创建RDD
    val data: Array[(Int, String)] = Array((1, "a"), (2, "b"), (3, "c"))
    // 并行化生成rdd 分区数量
    val rdd1: RDD[(Int, String)] = sc.parallelize(data, 3)
    // 生成RangePartitioner 分区器
    val rdd2: RDD[(Int, String)] = rdd1.sortByKey()
    val rdd3: RDD[(Int, String)] = rdd2.filterByRange(1,2)
    println(rdd3.collect().toBuffer)
    println(rdd3.partitions.size)
    println(rdd3.collect().toBuffer)

  }
}
