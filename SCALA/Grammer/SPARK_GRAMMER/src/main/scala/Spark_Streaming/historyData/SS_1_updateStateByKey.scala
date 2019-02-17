package Spark_Streaming.historyData

import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.streaming.{Durations, StreamingContext}

/**
  * 用途:不要有子目录，格式一定要适合,新加入的文件一定要修改，不仅仅是名字
  * 作者：sylar-lee
  * 日期:2019/2/1 11:08
  */
object SS_1_updateStateByKey {

  def main(args: Array[String]): Unit = {
    // 必须两个以上线程
    val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[3]")
    // 新建一个入口 一秒钟一个批处理
    val streamingContext: StreamingContext = new StreamingContext(sparkConf,Durations.seconds(3))
    // 如果使用了stateful的算子，必须要设置checkpoint 用来保存中间结果 不然丢了程序白跑了
    // 在生产环境中，建议大家把checkpoint设置到HDFS的某个文件夹中
    streamingContext.checkpoint("C:\\data\\checkPoint")
    // 监控本地文件夹
    val lines: DStream[String] = streamingContext.textFileStream("C:\\data\\sparkStreaming")
    // 得到单词
    val words: DStream[String] = lines.flatMap(_.split(" "))
    val pairs: DStream[(String, Int)] = words.map((_,1))
    // Return a new "state" DStream where the state for each key is updated by applying
    // the given function on the previous state of the key and the new values of each key.
    val reslut: DStream[(String, Int)] = pairs.updateStateByKey(updateFunction)
    reslut.print()
    // 启动流式处理
    streamingContext.start()
    // 等待停止信号
    streamingContext.awaitTermination()
  }

  /**
    * 三个参数 key:这里是单词
    * 二个参数：当前批次单词出现的次数,相当于value 但是有多个分区，所以是一个序列
    * 第三个：累加的中间结果
    */
  def updateFunction(currentValues: Seq[Int], preValues: Option[Int]): Option[Int] = {
    val current: Int = currentValues.sum
    // 没有就是0
    val pre: Int = preValues.getOrElse(0)
    Some(current + pre)
  }
}
