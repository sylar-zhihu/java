package MCLog.clean.oneStep

import java.util.{Date, Locale}

import org.apache.commons.lang3.time.FastDateFormat

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54
  */
object Step_2_Time {

  // 原始数据 10/Nov/2016:00:01:02 +0800
  // FastDateFormat 线程安全
  val OlD_FORMAT: FastDateFormat = FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH)

  val OUT_FORMAT: FastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")


  // 把日志时间变成标准时间格式
  def getNewFormatTime(time: String)= {
    try {
//      println(OlD_FORMAT.parse(time))// 解析时间
//      println(OlD_FORMAT.parse(time).getTime)// 变成long类型
      OUT_FORMAT.format(new Date(OlD_FORMAT.parse(time).getTime))
    } catch {
      case e: Exception =>
        OUT_FORMAT.format(new Date(0))
    }

  }

  def main(args: Array[String]): Unit = {

    // 得到单独的一条日志
    val time = "10/Nov/2016:00:01:02 +0800"



    println(getNewFormatTime(time))

  }
}
