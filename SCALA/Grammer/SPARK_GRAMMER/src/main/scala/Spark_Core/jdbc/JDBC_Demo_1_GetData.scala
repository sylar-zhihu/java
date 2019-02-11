package Spark_Core.jdbc

import java.sql.DriverManager

import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.sql.execution.datasources.jdbc.JDBCRDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * 使用MySQL数据库,读取的数据为RDD 类型
  *
  */
object JDBC_Demo_1_GetData {

  // 定义一个函数 返回connection
  val getConnection = () => {
    DriverManager.getConnection("jdbc:mysql://localhost:3306/spark?characterEncoding=utf8", "root", "123")
  }

  def main(args: Array[String]): Unit = {
    // 配置应用程序名字 local表示不调用集群 * 表示使用所有空闲的进程
    val conf: SparkConf = new SparkConf().setAppName("Spark_WordCount_HDFS").setMaster("local[*]")
    // 得到上下文
    val sc: SparkContext = new SparkContext(conf)
    // 从数据库读取数据 都用等于比较好
    val mysqlRdd: JdbcRDD[(Int, String)] = new JdbcRDD(
      sc, getConnection, "select * from spark1 where id>= ? AND id<=?", 1, 4, 3,
      rs => {
        val id = rs.getInt(1)
        val word = rs.getString(2)
        (id, word)
      }
    )

    // 执行
    val tuples: Array[(Int, String)] = mysqlRdd.collect()
    println(tuples.toBuffer)

    // 关闭连接
    sc.stop()
  }
}
