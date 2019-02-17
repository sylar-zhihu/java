package Spark_Streaming.singleData

import java.sql.DriverManager

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Durations, StreamingContext}

/**
  * 用途:不要有子目录，格式一定要适合
  * 作者：sylar-lee
  * 日期:2019/2/1 11:08
  */
object WordCountMysql {

  def main(args: Array[String]): Unit = {
    // 必须两个以上线程
    val sparkConf = new SparkConf().setAppName("WordCountMysql").setMaster("local[*]")
    // 新建一个入口 一秒钟一个批处理
    val streamingContext = new StreamingContext(sparkConf, Durations.seconds(8))
    // 监控本地文件夹
    val lines = streamingContext.textFileStream("C:\\data\\sparkStreaming")
    // 得到单词
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map((_, 1))
    val reslut = pairs.reduceByKey(_ + _)
    // 打印数据
    reslut.print()
    // 存入mysql
    reslut.foreachRDD(rdd => {
      //  每一个分区建立一个连接
      rdd.foreachPartition(partitionOfRecords => {
        val connection = createConnection()
        partitionOfRecords.foreach(record => {
          val sql = "insert into word_count(word,count) values ('" + record._1 + "',"  + record._2 + ")"
          connection.createStatement().execute(sql)
        })
        connection.close()
      })
    }

    )
    // 启动流式处理
    streamingContext.start()
    // 等待停止信号
    streamingContext.awaitTermination()
  }

  // 连接mysql
  def createConnection() = {
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://localhost:3306/spark", "root", "123")
  }

}
