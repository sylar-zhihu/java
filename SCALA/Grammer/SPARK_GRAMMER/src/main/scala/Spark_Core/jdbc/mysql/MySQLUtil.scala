package Spark_Core.jdbc.mysql

import java.sql.{Connection, DriverManager, PreparedStatement}

/**
  * 用途:把数据写入mysql
  * 作者：sylar-lee
  * 日期:2019/1/30 18:48
  */
object MySQLUtil {

  // 定义一个函数 返回connection
  def getConnection() = {
    DriverManager.getConnection("jdbc:mysql://localhost:3306/spark?characterEncoding=utf8", "root", "123")
  }

  // 释放资源
  /**
    * 释放数据库连接等资源
    *
    * @param connection
    * @param pstmt
    */
  def release(connection: Connection, pStatement: PreparedStatement): Unit = {
    try {
      if (pStatement != null) {
        pStatement.close()
      }
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      if (connection != null) {
        connection.close()
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val con: Connection = getConnection()
    // 打印输出 证明连接成功
    println(con)
  }

}
