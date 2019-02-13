package SPARK_SQL.homeWork

import Spark_Core.homeWork.IP.{Demo_1_IPToLong, Demo_2_getProvince, IPUtil}
import org.apache.spark.SparkContext
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

/**
  * 优化 广播变量
  * 本地参数
  * C:\data\ip.lee C:\data\access.lee
  *
  */
object Demo_2 {

  case class Ip(start: Long, end: Long, province: String)

  def main(args: Array[String]): Unit = {

    //创建sparkSession()并设置App名称
    val sparkSession: SparkSession = SparkSession
      .builder().master("local[3]")
      .appName("Spark SQL basic example")
      // 配置某些spark运行的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    val sc: SparkContext = sparkSession.sparkContext

    // 取到HDFS中的ip规则
    val rulesLines: RDD[String] = sc.textFile(args(0))

    // 加入隐式转化
    import sparkSession.implicits._
    //整理ip规则数据
    val ipRulesDF: RDD[(Long, Long, String)] = rulesLines.map(line => {
      val fields: Array[String] = line.split("[|]")
      val startNum: Long = fields(2).toLong
      val endNum: Long = fields(3).toLong
      val province: String = fields(6)
      (startNum, endNum, province)
    })

    // 收集数据
    val ipRulesArray: Array[(Long, Long, String)] = ipRulesDF.collect()
    // 广播数据
    val ipRulesArrayBC: Broadcast[Array[(Long, Long, String)]] = sc.broadcast(ipRulesArray)


    //创建RDD，读取访问日志
    val accessLines: RDD[String] = sc.textFile(args(1))

    // 得到IP
    val ipDF: DataFrame = accessLines.map(log => {
      //将log日志的每一行进行切分
      val fields: Array[String] = log.split("[|]")
      val ip = fields(1)
      //将ip转换成十进制
      val ipNum: Long = Demo_1_IPToLong.ip2Long(ip)
      ipNum
    }).toDF("ipNum")

    ipDF.createTempView("v_log")

    //定义一个自定义函数（UDF），并注册
    //该函数的功能是（输入一个IP地址对应的十进制，返回一个省份名称）
    sparkSession.udf.register("ip2Province", (ipNum: Long) => {
      //查找ip规则（事先已经广播了，已经在Executor中了）
      val ipRulesInExecutor: Array[(Long, Long, String)] = ipRulesArrayBC.value
      //根据IP地址对应的十进制查找省份名称
      val index: Int = Demo_2_getProvince.binarySearch(ipRulesInExecutor, ipNum)
      var province = "未知"
      if(index != -1) {
        province = ipRulesInExecutor(index)._3
      }
      province
    })


    val r = sparkSession.sql("SELECT ip2Province(ipNum) province, COUNT(*) counts " +
      "FROM v_log GROUP BY province ORDER BY counts DESC")

    r.show()

  }
}
