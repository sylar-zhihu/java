package Spark_Core.jdbc.mysql

import java.sql.{Connection, DriverManager, PreparedStatement}

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 数据插入mysql
  *
  */
object JDBC_Demo_2_Write {

  // 定义一个函数 返回connection
  val getConnection = () => {
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://localhost:3306/spark?characterEncoding=utf8", "root", "123")

  }

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_WordCount_HDFS").setMaster("local[*]")
    // 得到上下文
    val sc: SparkContext = new SparkContext(conf)

    // 1）由一个已经存在的Scala集合创建RDD
    val data: Array[(String, Int)] = Array(("a", 1), ("b", 2))
    // 并行化生成rdd 分区数量
    val rdd1: RDD[(String, Int)] = sc.parallelize(data, 3)
    // 插入


    //一次拿出一个分区(一个分区用一个连接，可以将一个分区中的多条数据写完在释放jdbc连接，这样更节省资源)
    rdd1.foreachPartition(it => {
      val conn: Connection = getConnection()
      //将数据通过Connection写入到数据库
      val pstm: PreparedStatement = conn.prepareStatement("INSERT INTO spark1 VALUES (?, ?)")
      //将一个分区中的每一条数据拿出来
      it.foreach(tp => {
        pstm.setInt(1, tp._2)
        pstm.setString(2, tp._1)
        pstm.executeUpdate()
      })
      pstm.close()
      conn.close()
    })

  }
}
