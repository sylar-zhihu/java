package Spark_Core.homeWork.sort

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 最受欢迎的老师,不使用对象传递
  */
object SortClass2 {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val sparkConf: SparkConf = new SparkConf().setAppName("TopTeacher").setMaster("local[*]")
    // sparkConf得到sparkContext
    val sc: SparkContext = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("C://data//sort.txt")
    // 切分数据
    val dataRdd: RDD[(String, Int, Int)] = lines.map(line => {
      val splits: Array[String] = line.split(" ")
      val name: String = splits(0)
      val num1: Int = splits(1).toInt
      val num2: Int = splits(2).toInt
      (name, num1, num2)
    })

    // 传递的只是一个规则
    val sorted: RDD[(String, Int, Int)] = dataRdd.sortBy(u => new User2( u._2, u._3))
    val result: Array[(String, Int, Int)] = sorted.collect()

    println(result.toBuffer)

  }

}

