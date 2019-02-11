package Spark_Core.homeWork.IP

import scala.io.{BufferedSource, Source}

/**
  * 用途:读取数据
  * 作者：ljb
  * 日期:2019/2/11 16:42 
  */
object Demo_2 {

  // 把ip转化为十进制
  def ip2Long(ip: String): Long = {
    // 按照.切分
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length){
      ipNum =  fragments(i).toLong | ipNum << 8L
    }
    ipNum
  }

  // 读取规则函数
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

  def main(args: Array[String]): Unit = {
    val ip: Long = ip2Long("14.215.177.39")
    println(ip)
    println(ip2Long("0.0.0.1"))// 1
    println(ip2Long("0.0.1.0"))// 256
    println(ip2Long("0.0.2.1"))// 256*2+1 =513
    println(ip2Long("0.1.0.0"))// 65536

  }

}
