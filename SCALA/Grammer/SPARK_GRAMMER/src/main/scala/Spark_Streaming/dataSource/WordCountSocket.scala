package Spark_Streaming.dataSource

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Durations, StreamingContext}

/**
  * 用途:只能在linux上使用
  * 作者：sylar-lee
  * 日期:2019/2/1 11:08
  */
object WordCountSocket {

  def main(args: Array[String]): Unit = {
    // 必须两个以上线程
    val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[3]")
    // 新建一个入口 一秒钟一个批处理
    val streamingContext = new StreamingContext(sparkConf,Durations.seconds(1))
    // 监听这个端口
    val lines: ReceiverInputDStream[String] = streamingContext.socketTextStream("hadoop01",9999)
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
