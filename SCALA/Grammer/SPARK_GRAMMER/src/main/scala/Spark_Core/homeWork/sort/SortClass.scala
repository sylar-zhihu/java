package Spark_Core.homeWork.sort

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 最受欢迎的老师
  */
object SortClass {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val sparkConf: SparkConf = new SparkConf().setAppName("TopTeacher").setMaster("local[*]")
    // sparkConf得到sparkContext
    val sc: SparkContext = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("C://data//sort.txt")
    // 切分数据
    val dataRdd: RDD[User] = lines.map(line => {
      val splits: Array[String] = line.split(" ")
      val name: String = splits(0)
      val num1: Int = splits(1).toInt
      val num2: Int = splits(2).toInt
      new User(name, num1, num2)
    })

    val sorted: RDD[User] = dataRdd.sortBy(u => u)
    val result: Array[User] = sorted.collect()

    println(result.toBuffer)

  }

}

