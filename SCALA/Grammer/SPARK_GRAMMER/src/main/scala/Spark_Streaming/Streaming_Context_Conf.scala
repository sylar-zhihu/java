package Spark_Streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, StreamingContext}

/**
  * 用途:不要有子目录，格式一定要适合,新加入的文件一定要修改，不仅仅是名字
  * 作者：sylar-lee
  * 日期:2019/2/1 11:08
  */
object Streaming_Context_Conf {

  def main(args: Array[String]): Unit = {
    // 必须两个以上线程
    val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[3]")
    // sparkSteaming的入口点
    val streamingContext: StreamingContext = new StreamingContext(sparkConf,Durations.seconds(3))
    // 得到context
    val sparkContext = streamingContext.sparkContext
  }

}
