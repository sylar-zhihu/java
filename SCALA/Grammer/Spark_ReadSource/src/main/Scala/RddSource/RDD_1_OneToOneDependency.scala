package RddSource

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 每个Rdd都有dependency属性
  * action才会生成对应的dependency
  */
object RDD_1_OneToOneDependency {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_1_Create_RDD_Scala").setMaster("local[*]")
    // 创建SparkContext
    val sc: SparkContext = new SparkContext(conf)
    // 搜索 config.clone()

    // 1）由一个已经存在的Scala集合创建RDD
    val data: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8)
    // 并行化生成rdd 分区数量
    val rdd1: RDD[Int] = sc.parallelize(data, 3)
    // 调用map 新生成一个RDD action才会生成对应的dependency
    val rdd2: RDD[Int] = rdd1.map(_*2)

    // 执行action操作
    println(rdd2.collect().toBuffer)
    sc.stop()

  }
}
