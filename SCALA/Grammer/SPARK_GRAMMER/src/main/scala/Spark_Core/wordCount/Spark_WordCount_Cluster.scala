package Spark_Core.wordCount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 两个参数
  * 第一个是读取路径
  * 第二个是保存路径是一个文件夹
  * spark-submit \
  * --class Spark_Core.Spark_WordCount_Cluster \
  * --master spark://hadoop01:7077 \
  * /root/SPARK_GRAMMER.jar \
  * hdfs://hadoop01:9000/a.txt \
  * hdfs://hadoop01:9000/spark
  *
  */
object Spark_WordCount_Cluster {

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_WordCount_HDFS")
    // 得到上下文
    val sc: SparkContext = new SparkContext(conf)
    // 读取数据 用参数
    val lines: RDD[String] = sc.textFile(args(0))
    //    var lines= sc.textFile("file:///root/wordCount")


    // 分成一个一个的单词
    val words: RDD[String] = lines.flatMap(line => line.split(" "))
    // Array[String] = Array(as, before, i, live, da, mama)
    // 变成可统计的
    val wordOne: RDD[(String, Int)] = words.map(x => (x, 1))
    // Array[(String, Int)] = Array((as,1), (before,1), (i,1), (live,1), (da,1), (mama,1))
    // 统计
    val total: RDD[(String, Int)] = wordOne.reduceByKey(_ + _)
    // 输出
    total.saveAsTextFile(args(1))

    // 关闭连接
    sc.stop()
  }
}
