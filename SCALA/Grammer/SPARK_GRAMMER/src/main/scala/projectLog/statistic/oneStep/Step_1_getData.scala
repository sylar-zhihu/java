package projectLog.statistic.oneStep

import Spark_Core.homeWork.IP.IPUtil
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/30 15:53
  */
object Step_1_getData {
  val struct: StructType = StructType(
    Array(
      StructField("url", StringType),
      StructField("cmsType", StringType),
      StructField("cmsID", LongType),
      StructField("traffic", LongType),
      StructField("ip", StringType),
      StructField("city", StringType),
      StructField("time", StringType),
      StructField("day", StringType)
    )

  )

  /**
    * 把数据解析
    * 2017-05-11 13:37:22	http://www.imooc.com/article/17895	701	218.22.9.56
    *
    * @param log
    */
  def parseLog(log: String) = {
    try {
      val splits: Array[String] = log.split("\t")
      // http://www.imooc.com/article/17895
      val url: String = splits(1)
      val traffic: Long = splits(2).toLong
      val ip: String = splits(3)
      val domain = "http://www.imooc.com/"
      // article/17895
      val cms: String = url.substring(url.indexOf(domain) + domain.length)
      //
      val cmsSplits: Array[String] = cms.split("/")
      var cmsType = ""
      var cmsID = 0l
      // type 不一定有
      if (cmsSplits.length > 1) {
        cmsType = cmsSplits(0)
        cmsID = cmsSplits(1).toLong

      }

      val city = IPUtil.IpGetProvince(ip)
      // 2017-05-11 04:18:47
      val time = splits(0)
      // 20170511
      val day: String = time.substring(0, 10).replaceAll("-", "")
      Row(url, cmsType, cmsID, traffic, ip, city, time, day)
    } catch {
      case e: Exception => Row(0)

    }

  }

  def main(args: Array[String]): Unit = {

    // 把一行日志转换为RDD需要的ROW 格式
    val log = "2017-05-11 14:09:14\thttp://www.imooc.com/video/4500\t304\t218.75.35.226"

    val unit: Any = parseLog(log)

    println(unit)
  }



}
