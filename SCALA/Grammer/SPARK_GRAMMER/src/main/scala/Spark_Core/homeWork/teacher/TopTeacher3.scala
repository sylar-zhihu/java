package Spark_Core.homeWork.teacher

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 最受欢迎的老师,分学科
  * 优化
  */
object TopTeacher3 {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val sparkConf: SparkConf = new SparkConf().setAppName("TopTeacher").setMaster("local[*]")
    // sparkConf得到sparkContext
    val sc: SparkContext = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("C://teacher.lee")
    // 切分数据
    val subTeacherOne: RDD[((String, String), Int)] = lines.map(line => {
      val splits: Array[String] = line.split("/")
      val sub = splits(2).split("\\.")(0)
      val teacher = splits(3)
      ((sub,teacher),1)
    })
    // 统计
    val subTeacherNum: RDD[((String, String), Int)] = subTeacherOne.reduceByKey(_+_)
    // 分组
    val value: RDD[(String, Iterable[((String, String), Int)])] = subTeacherNum.groupBy(_._1._1)
    //
    val result: RDD[(String, List[((String, String), Int)])] = value.mapValues(_.toList.sortBy(_._2).reverse)
    // 输出
    println(result.collect().toBuffer)







  }

}
