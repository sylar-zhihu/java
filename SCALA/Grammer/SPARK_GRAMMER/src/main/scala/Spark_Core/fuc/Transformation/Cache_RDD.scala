package Spark_Core.fuc.Transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author asus
  * chache保存数据
  */
object Cache_RDD {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("p1").setMaster("local[3]")
    val sc: SparkContext = new SparkContext(conf)
    Logger.getRootLogger.setLevel(Level.WARN)
    val rdd1: RDD[Int] = sc.parallelize(1 to 3, 3)
    // 缓存 不会立即执行
    val noCashe: RDD[String] = rdd1.map(_.toString+System.currentTimeMillis())
    // 每次执行都会改变
    noCashe.collect()
    // 等于persist(org.apache.spark.storage.StorageLevel.MEMORY_ONLY) 这个级别
    // 源码中有
    val cacheRdd: RDD[String] = rdd1.map(_.toString+System.currentTimeMillis()).cache()
    // 每次不会变，说明不是重新计算
    cacheRdd.collect()
    // 设置其他级别
    rdd1.cache.persist(org.apache.spark.storage.StorageLevel.MEMORY_ONLY)
    // 释放 数据
    cacheRdd.unpersist()


  }
}
