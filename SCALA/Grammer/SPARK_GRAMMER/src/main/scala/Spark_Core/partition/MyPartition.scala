package Spark_Core.partition

import org.apache.spark.{Partitioner}

/**
  * 用途:使用自定义分区
  * 作者：sylar-lee
  * 日期:2019/2/7 10:37 
  */

/**
  * 自己写的自定义分区函数，继承spark的分区函数
  *
  * @param numParts
  */




class MyPartition(numParts: Int) extends Partitioner {

  // 分区的数量
  override def numPartitions: Int = numParts

  // 输入一个key返回分区的数量
  override def getPartition(key: Any): Int = {
    val ckey: String = key.toString
    // 这里是根据最后一位分区
    ckey.substring(ckey.length - 1).toInt % numParts
  }
}
