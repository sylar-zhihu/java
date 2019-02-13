package SPARK_SQL.homeWork
import Spark_Core.homeWork.IP.{Demo_1_IPToLong, IPUtil}
import org.apache
import org.apache.spark
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 本地参数
  * C:\data\ip.lee C:\data\access.lee
  *
  */
object Demo_1 {

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
    val rulesLines:RDD[String] = sc.textFile(args(0))

    // 加入隐式转化
    import sparkSession.implicits._
    //整理ip规则数据
    val ipRulesDF: DataFrame = rulesLines.map(line => {
      val fields: Array[String] = line.split("[|]")
      val startNum: Long = fields(2).toLong
      val endNum: Long = fields(3).toLong
      val province: String = fields(6)
      Ip(startNum, endNum, province)
    }).toDF("startNum","endNum","province")


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

    ipRulesDF.createTempView("v_rules")
    ipDF.createTempView("v_ips")

    val r = sparkSession.sql("SELECT province, count(*) counts FROM " +
      "v_ips JOIN v_rules ON (ipNum >= startNum AND ipNum <= endNum) " +
      "GROUP BY province ORDER BY counts DESC")

    r.show()


  }
}
