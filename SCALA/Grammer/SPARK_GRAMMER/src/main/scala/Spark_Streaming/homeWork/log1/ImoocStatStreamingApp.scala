package Spark_Streaming.homeWork.log1

import Spark_Streaming.homeWork.log1.dao.{CourseClickCountDAO, CourseSearchClickCountDAO}
import Spark_Streaming.homeWork.log1.domain.{ClickLog, CourseClickCount, CourseSearchClickCount}
import Spark_Streaming.homeWork.log1.util.DateUtils
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.ListBuffer

/**
  * 日志实战项目
  * py执行命令 python create-log.py /root/data/streaming/data.txt
  * hbase创建表：create 'imooc_course_clickcount','info'
  * desc 'imooc_course_clickcount'
  * Row key:day_courseid
  * 传入的参数 hadoop01:2181 test s1 1
  */
object ImoocStatStreamingApp {

  def main(args: Array[String]): Unit = {

    //
    if (args.length != 4) {
      println("Usage: ImoocStatStreamingApp <zkQuorum> <group> <topics> <numThreads>")
      System.exit(1)
    }

    val Array(zkQuorum, groupId, topics, numThreads) = args

    val sparkConf: SparkConf = new SparkConf().setAppName("ImoocStatStreamingApp").setMaster("local[5]")
    val ssc = new StreamingContext(sparkConf, Seconds(60))

    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap

    // 接受kafka的数据
    val messages: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream(ssc, zkQuorum, groupId, topicMap)

    // 测试步骤一：测试数据接收
    //messages.map(_._2).count().print

    // 得到数据
    // 187.29.72.87	2019-02-18 11:12:06	"GET /class/146.html HTTP/1.1"	500	https://www.baidu.com/s?wd=storm实战
    // 167.132.29.46	2019-02-18 11:12:06	"GET /class/145.html HTTP/1.1"	404	-
    val logs = messages.map(_._2)
    // 分割
    val cleanData = logs.map(line => {
      // 切分数据
      val dataSplit = line.split("\t")

      // dataSplit(2) = "GET /class/130.html HTTP/1.1"
      // url = /class/130.html
      val url = dataSplit(2).split(" ")(1)
      // 设置为0 用来过滤
      var courseId = 0

      // 拿到课程ID编号
      if (url.startsWith("/class")) {
        val courseIdHTML = url.split("/")(2)
        courseId = courseIdHTML.substring(0, courseIdHTML.lastIndexOf(".")).toInt
      }

      ClickLog(dataSplit(0), DateUtils.parseToMinute(dataSplit(1)), courseId, dataSplit(3).toInt, dataSplit(4))
    }).filter(clicklog => clicklog.courseId != 0)


     cleanData.print()// OK

    // 测试步骤三：统计今天到现在为止实战课程的访问量

    cleanData.map(x => {

      // HBase rowkey设计： 20171111_88

      (x.time.substring(0, 8) + "_" + x.courseId, 1)
    }).reduceByKey(_ + _).foreachRDD(rdd => {
      // 遍历每个分区
      rdd.foreachPartition(partitionRecords => {
        val list = new ListBuffer[CourseClickCount]
        // 遍历每一条数据
        partitionRecords.foreach(pair => {
          list.append(CourseClickCount(pair._1, pair._2))
        })

        CourseClickCountDAO.save(list)
      })
    })


    // 测试步骤四：统计从搜索引擎过来的今天到现在为止实战课程的访问量

    cleanData.map(x => {

      /**
        * https://www.sogou.com/web?query=Spark SQL实战
        *
        * ==>
        *
        * https:/www.sogou.com/web?query=Spark SQL实战
        */
      val referer = x.referer.replaceAll("//", "/")
      val splits = referer.split("/")
      var host = ""
      if (splits.length > 2) {
        host = splits(1)
      }

      (host, x.courseId, x.time)
    }).filter(_._1 != "").map(x => {
      (x._3.substring(0, 8) + "_" + x._1 + "_" + x._2, 1)
    }).reduceByKey(_ + _).foreachRDD(rdd => {
      rdd.foreachPartition(partitionRecords => {
        val list = new ListBuffer[CourseSearchClickCount]

        partitionRecords.foreach(pair => {
          list.append(CourseSearchClickCount(pair._1, pair._2))
        })

        CourseSearchClickCountDAO.save(list)
      })
    })

    ssc.start()
    ssc.awaitTermination()
  }

}
