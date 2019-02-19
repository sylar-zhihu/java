package com.imooc.spark


import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import kafka.serializer.StringDecoder
/**
  * Direct 更好的方式，没有receiver,性能更高,不能显示zk的偏移量
  */
object Kafka_Direct_Word_local {

  def main(args: Array[String]): Unit = {

    if(args.length != 2) {
      System.err.println("Usage: KafkaDirectWordCount <brokers> <topics>")
      System.exit(1)
    }

    val Array(brokers, topics) = args

    val sparkConf = new SparkConf() //.setAppName("KafkaReceiverWordCount")
      //.setMaster("local[2]")

    val ssc = new StreamingContext(sparkConf, Seconds(5))

    val topicsSet = topics.split(",").toSet
    val kafkaParams = Map[String,String]("metadata.broker.list"-> brokers)

    //  Spark Streaming如何对接Kafka
    val messages = KafkaUtils.createDirectStream[String,String,StringDecoder,StringDecoder](
    ssc,kafkaParams,topicsSet
    )

    // TODO... 自己去测试为什么要取第二个
    messages.map(_._2).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
