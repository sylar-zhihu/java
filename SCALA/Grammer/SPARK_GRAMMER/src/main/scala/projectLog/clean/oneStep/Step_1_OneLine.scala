package projectLog.clean.oneStep

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54
  */
object Step_1_OneLine {

  def cleanLog(log: String): String = {

    val splits: Array[String] = log.split(" ")

    val ip: String = splits(0)
    var time: String = splits(3) + splits(4)
    time = time.substring(1, time.length - 1)
    // 变成通用格式
    time = Step_2_Time.getNewFormatTime(time)
    // 流量
    val traffic = splits(9)
    // url
    var url = splits(11)
    url = url.substring(1, url.length - 1)
    // 返回
    time + "\t" + url + "\t" + traffic + "\t" + ip
  }

  def main(args: Array[String]): Unit = {

    // 得到单独的一条日志
    val log = "117.35.88.11 - - [10/Nov/2016:00:01:02 +0800] \"GET /article/ajaxcourserecommends?id=124 HTTP/1.1\" 200 2345 \"www.imooc.com\" \"http://www.imooc.com/code/1852\" - \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36\" \"-\" 10.100.136.65:80 200 0.616 0.616"

    val splits: Array[String] = log.split(" ")

    val ip: String = splits(0)
    var time: String = splits(3) + splits(4)
    time = time.substring(1, time.length - 1)
    // 流量
    val traffic = splits(9)
    // url
    var url = splits(11)
    url = url.substring(1, url.length - 1)

    println(s"ip: $ip")
    println(s"time: $time")
    println(s"traffic: $traffic")
    println(s"url: $url")

  }
}
