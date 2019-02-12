package Spark_Core.homeWork.teacher

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 最受欢迎的老师
  */
object TopTeacher1 {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val sparkConf: SparkConf = new SparkConf().setAppName("TopTeacher").setMaster("local[*]")
    // sparkConf得到sparkContext
    val sc: SparkContext = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("C://data//teacher.lee")
    // 切分数据
    val teacherAndOne: RDD[(String, Int)] = lines.map(line => {
      val splits: Array[String] = line.split("/")
      val sub = splits(2).split("\\.")(0)
      val teacher = splits(3)
      (teacher, 1)
    })
    val teacherNum: RDD[(String, Int)] = teacherAndOne.reduceByKey(_+_)
    val result: RDD[(String, Int)] = teacherNum.sortBy(_._2,false)
    val tuples: Array[(String, Int)] = result.collect()
    // 输出
    println(tuples.toBuffer)

  }

}
