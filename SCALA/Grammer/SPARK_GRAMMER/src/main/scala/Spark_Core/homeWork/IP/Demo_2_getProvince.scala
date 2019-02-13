package Spark_Core.homeWork.IP

import scala.io.{BufferedSource, Source}

/**
  * 用途:本地单机程序
  * 作者：ljb
  * 日期:2019/2/11 16:42 
  */
object Demo_2_getProvince {



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

  def main(args: Array[String]): Unit = {
    //数据是在内存中
    val rules: Array[(Long, Long, String)] = readRules("C:\\data\\ip.lee")
    //将ip地址转换成十进制
    val ipNum: Long = Demo_1_IPToLong.ip2Long("114.215.43.42")
    //查找
    val index: Int = binarySearch(rules, ipNum)
    //根据脚本到rules中查找对应的数据
    val tp = rules(index)
    val province: String = tp._3
    println(province)

  }

}
