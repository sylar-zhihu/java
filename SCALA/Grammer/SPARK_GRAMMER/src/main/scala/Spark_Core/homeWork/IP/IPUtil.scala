package Spark_Core.homeWork.IP

import Spark_Core.homeWork.IP.Demo_2_getProvince.{binarySearch, readRules}
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

  val rules = readRules("C:\\data\\ip.lee")

  /**
    * 传入一个IP返回对应城市
    *
    * @param String
    */
  def IpGetProvince(ip: String): String = {
    //将ip地址转换成十进制
    val ipNum: Long = Demo_1_IPToLong.ip2Long(ip)
    // 查找IP对应的下标
    val index: Int = Demo_2_getProvince.binarySearch(rules, ipNum)

    var province = "未知"

    if (index != -1) {
      province = rules(index)._3
    }
    // 根据脚本到rules中查找对应的数据
    province

  }

  def main(args: Array[String]): Unit = {
    val ipNum: String = IpGetProvince("114.215.43.42")
    println(ipNum)
  }
}
