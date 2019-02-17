package Spark_Streaming.historyData

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * transform把DStream和RDD一起操作
  */
object SS_2_Transform_RDD {


  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")

    val ssc = new StreamingContext(sparkConf, Seconds(5))


    /**
      * 需要过滤的数据
      */
    val blacks = List("c", "d")
    /*输入
    123 c
    456 a
     */
    // 转换成 RDD
    val blacksRDD: RDD[(String, Boolean)] = ssc.sparkContext.parallelize(blacks).map(x => (x, true))
    // 监听端口
    val lines: DStream[String] = ssc.textFileStream("C:\\data\\sparkStreaming")
    // 把输入数据变成 a,456 a
    val inputTuple: DStream[(String, String)] = lines.map(x => (x.split(" ")(1), x))
    // 通过join 筛选数据  a,(456 a,null)
    // transform 输入对RDD 操作的函数，返回DStream
    val clicklog: DStream[String] = inputTuple.transform(rdd => {
      rdd.leftOuterJoin(blacksRDD)
        // 不存在就是false
        .filter(x=> x._2._2.getOrElse(false) != true)
        .map(x=>x._2._1)
    })

    clicklog.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
