package Spark_Streaming.dataSource.kafka

import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
;

/**
  * Receiver对接kafka
  */
object Kafka_Receiver_local {

  def main(args: Array[String]): Unit = {


    val sparkConf = new SparkConf() .setAppName("KafkaReceiverWordCount").setMaster("local[3]")

    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val zkQuorum="hadoop01:2181"
    val group="test"
    // 可以有多个
    val topics="s1"
    val numThreads=1

    val topicMap: Map[String, Int] = topics.split(",").map((_, numThreads.toInt)).toMap

    //  得到流对象  zk的地址 group名字 topic名字 线程数
    val messages = KafkaUtils.createStream(ssc, zkQuorum, group,topicMap)

    // 取到第二个参数，就是流对象
    messages.map(_._2).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
