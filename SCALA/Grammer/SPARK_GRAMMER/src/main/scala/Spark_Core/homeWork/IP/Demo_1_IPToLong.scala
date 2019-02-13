package Spark_Core.homeWork.IP

/**
  * 用途:定义一个函数把IP变成数字类型
  * 作者：ljb
  * 日期:2019/2/11 16:42 
  */
object Demo_1_IPToLong {

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

  def main(args: Array[String]): Unit = {
    val ip: Long = ip2Long("14.215.177.39")
    println(ip)
    println(ip2Long("0.0.0.1"))// 1
    println(ip2Long("0.0.1.0"))// 256
    println(ip2Long("0.0.2.1"))// 256*2+1 =513
    println(ip2Long("0.1.0.0"))// 65536

  }

}
