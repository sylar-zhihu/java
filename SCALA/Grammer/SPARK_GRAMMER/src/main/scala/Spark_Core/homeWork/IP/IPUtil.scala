package Spark_Core.homeWork.IP

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.{BufferedSource, Source}

/**
  * 本地参数
  * C:\data\ip.lee C:\data\access.lee
  *
  */
object IPUtil {

  // 把ip转化为十进制
  def ip2Long(ip: String): Long = {
    // 按照.切分
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length) {
      ipNum = fragments(i).toLong | ipNum << 8L
    }
    ipNum
  }

  /**
    * 读取规则函数
    *
    * @param path
    * @return 起始数字，结束数字，省份
    */
  def readRules(path: String): Array[(Long, Long, String)] = {
    //读取ip规则
    val bf: BufferedSource = Source.fromFile(path)
    val lines: Iterator[String] = bf.getLines()
    //对ip规则进行整理，并放入到内存
    val rules: Array[(Long, Long, String)] = lines.map(line => {
      val segs: Array[String] = line.split("[|]")
      val startNum: Long = segs(2).toLong
      val endNum: Long = segs(3).toLong
      val province: String = segs(6)
      (startNum, endNum, province)
    }).toArray
    rules
  }

  /**
    * 找到IP对应的Array的下标，没找到返回0
    *
    * @param lines
    * @param ip
    * @return
    */
  def binarySearch(lines: Array[(Long, Long, String)], ip: Long): Int = {
    var low = 0
    var high: Int = lines.length - 1
    while (low <= high) {
      val middle: Int = (low + high) / 2
      if ((ip >= lines(middle)._1) && (ip <= lines(middle)._2))
        return middle
      if (ip < lines(middle)._1)
        high = middle - 1
      else {
        low = middle + 1
      }
    }
    -1
  }
}
