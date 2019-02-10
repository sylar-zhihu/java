package Spark_Core.wordCount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 用途:
  * 作者：ljb
  * 日期:2019/2/10 15:10 
  */
object Spark_WordCount_Local {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
   val conf: SparkConf = new SparkConf().setAppName("Spark_Word_Count").setMaster("local[*]")
    // 得到上下文
    val sc: SparkContext = new SparkContext(conf)
    // 读取数据 用参数
    val lines: RDD[String] = sc.textFile("C://a.txt")
    // TODO
    // var lines= sc.textFile("file:///root/wordCount")

    // 打印数据 是一个List
    lines.collect() // ArrayBuffer(as before, i live da mama)
    // 分成一个一个的单词
    val words: RDD[String] = lines.flatMap(line => line.split(" "))
    words.collect()
    // Array[String] = Array(as, before, i, live, da, mama)
    // 变成可统计的
    val wordOne: RDD[(String, Int)] = words.map(x => (x, 1))
    wordOne.collect()
    // Array[(String, Int)] = Array((as,1), (before,1), (i,1), (live,1), (da,1), (mama,1))
    // 统计
    val total: RDD[(String, Int)] = wordOne.reduceByKey(_ + _)
    total.collect()
    // 输出
    total.saveAsTextFile(args(1))

    // 关闭连接
    sc.stop()
  }
}
