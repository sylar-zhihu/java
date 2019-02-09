package projectLog.old

import org.apache.spark.sql.SparkSession

/**
  * 用途:
  * 作者：sylar-lee
  * 日期:2019/1/30 13:54
  */
object CleanLog {

  def main(args: Array[String]): Unit = {
    //创建SparkSession并设置App名称
    val sparkSession = SparkSession
      .builder().master("local[1]")
      .appName("Spark SQL basic example")
      // 读取某些配置 运行时候传入的参数
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // 得到sparkContext
    val sparkContext = sparkSession.sparkContext
    // 读取RDD
    val rawRDD = sparkContext.textFile("C://log_100000.txt")


    rawRDD.map(line=>{
      try {
        // 10.100.0.1 - - [10/Nov/2016:00:01:02 +0800] "HEAD / HTTP/1.1" 301 0 "117.121.101.40" "-" - "curl/7.19.7 (x86_64-redhat-linux-gnu) libcurl/7.19.7 NSS/3.16.2.3 Basic ECC zlib/1.2.3 libidn/1.18 libssh2/1.4.2" "-" - - - 0.000
        val splits=line.split(" ")
        // 10.100.0.1
        val ip = splits(0)
        // [10/Nov/2016:00:01:02 +0800]
        val time =splits(3)+" "+splits(4)
        // url
        val url=splits(11).replaceAll("\"","")
        // 流量
        val traffic= splits(9)
        (DateUtil.parse(time)+"\t"+url+"\t"+traffic+"\t"+ip)
      } catch {

        case e: Exception => {

        }
      }



    }).saveAsTextFile("C://log_clean")
    println("down")
  }

}
