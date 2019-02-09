package Spark_Streaming.singleData

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, StreamingContext}

/**
  * 用途:不要有子目录，格式一定要适合,新加入的文件一定要修改，不仅仅是名字
  * 作者：sylar-lee
  * 日期:2019/2/1 11:08
  */
object WordCountFile {

  def main(args: Array[String]): Unit = {
    // 必须两个以上线程
    val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[3]")
    // 新建一个入口 一秒钟一个批处理
    val streamingContext = new StreamingContext(sparkConf,Durations.seconds(3))
    // 监控本地文件夹
    val lines = streamingContext.textFileStream("C://data")
    // 得到单词
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map((_,1))
    val reslut = pairs.reduceByKey(_+_)
    reslut.print()
    // 启动流式处理
    streamingContext.start()
    // 等待停止信号
    streamingContext.awaitTermination()
  }

}
