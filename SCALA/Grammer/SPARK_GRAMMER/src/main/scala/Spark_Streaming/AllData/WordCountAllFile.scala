package Spark_Streaming.AllData

import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.streaming.{Durations, StreamingContext}

/**
  * 用途:不要有子目录，格式一定要适合,新加入的文件一定要修改，不仅仅是名字
  * 作者：sylar-lee
  * 日期:2019/2/1 11:08
  */
object WordCountAllFile {

  def main(args: Array[String]): Unit = {
    // 必须两个以上线程
    val sparkConf = new SparkConf().setAppName("wordCount").setMaster("local[3]")
    // 新建一个入口 一秒钟一个批处理
    val streamingContext = new StreamingContext(sparkConf,Durations.seconds(3))
    // 如果使用了stateful的算子，必须要设置checkpoint 用来保存中间结果 不然丢了程序白跑了
    // 在生产环境中，建议大家把checkpoint设置到HDFS的某个文件夹中
    streamingContext.checkpoint("C://log")
    // 监控本地文件夹
    val lines = streamingContext.textFileStream("C://data")
    // 得到单词
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map((_,1))
    // 分区器 是否以后依然使用这个分区器
    val reslut = pairs.updateStateByKey(updateFuc,new HashPartitioner(streamingContext.sparkContext.defaultParallelism),true)
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
  val updateFuc=(iterator: Iterator[(String,Seq[Int],Option[Int])])=>{
    iterator.map(t=>(t._1,t._2.sum+t._3.getOrElse(0)))


  }

}
