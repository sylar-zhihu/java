package projectLog.old

import java.util.{Date, Locale}

import org.apache.commons.lang3.time.FastDateFormat

/**
  * 用途:日期解析工具类
  * 作者：sylar-lee
  * 日期:2019/1/30 14:06
  */
object DateUtil {
  // 原始数据 [10/Nov/2016:00:01:02 +0800]
  val oldFormat = FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH)

  val OUT_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")

  /**
    * 获取时间 调整格式后的时间
    *
    * @param time
    * @return
    */
  def parse(time: String) = {
    OUT_FORMAT.format(new Date(getTime(time)))

  }

  /**
    * 获取日志输入时间
    * [10/Nov/2016:00:01:02 +0800]
    *
    * @param time
    */
  def getTime(time: String) = {

    try {
      oldFormat.parse(time.substring(
        time.indexOf("[") + 1, time.lastIndexOf("]"))).getTime
    } catch {

      case e: Exception => {
        0l
      }
    }

  }

  def main(args: Array[String]): Unit = {
    println(parse("[10/Nov/2016:00:01:02 +0800]"))
  }


}
