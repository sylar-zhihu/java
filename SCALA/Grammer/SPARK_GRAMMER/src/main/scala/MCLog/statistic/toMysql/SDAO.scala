package MCLog.statistic.toMysql

import java.sql.{Connection, PreparedStatement}

import Spark_Core.jdbc.mysql.MySQLUtil

import scala.collection.mutable.ListBuffer

/**
  * 用途:
  * 作者：ljb
  * 日期:2019/2/15 10:54 
  */
object SDAO {

  /**
    * 批量保存DayVideoAccessStat到数据库
    * 建表语句
    * CREATE TABLE `course_statistic` (
    * `day` varchar(255) NOT NULL,
    * `cms_id` bigint(255) NOT NULL,
    * `times` int(11) DEFAULT NULL
    * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
  def insertDayVideoAccessTopN(list: ListBuffer[CmsID_Statistic]): Unit = {
    var connection: Connection = null
    var pstmt: PreparedStatement = null
    try {
      connection = MySQLUtil.getConnection()
      // 一条一条提交，很浪费时间
      connection.setAutoCommit(false) //设置手动提交
      val sql = "insert into course_statistic(day,cms_id,times) values (?,?,?) "
      pstmt = connection.prepareStatement(sql)

      for (ele <- list) {
        pstmt.setString(1, ele.day)
        pstmt.setLong(2, ele.cmsId)
        pstmt.setLong(3, ele.times)

        pstmt.addBatch()
      }
      pstmt.executeBatch() // 执行批量处理
      connection.commit() //手工提交
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtil.release(connection, pstmt)
    }
  }

  /**
    * 批量保存DayCityVideoAccessStat到数据库
    */
  def insertDayCityVideoAccessTopN(list: ListBuffer[City_Statistic]): Unit = {

    var connection: Connection = null
    var pstmt: PreparedStatement = null

    try {
      connection = MySQLUtil.getConnection()

      connection.setAutoCommit(false) //设置手动提交

      val sql = "insert into city_statistic(day,cms_id,city,times,times_rank) values (?,?,?,?,?) "
      pstmt = connection.prepareStatement(sql)

      for (ele <- list) {
        pstmt.setString(1, ele.day)
        pstmt.setLong(2, ele.cmsId)
        pstmt.setString(3, ele.city)
        pstmt.setLong(4, ele.times)
        pstmt.setInt(5, ele.timesRank)
        pstmt.addBatch()
      }

      pstmt.executeBatch() // 执行批量处理
      connection.commit() //手工提交
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtil.release(connection, pstmt)
    }
  }

  /**
    * 批量保存DayVideoTrafficsStat到数据库
    */
  def insertDayVideoTrafficsAccessTopN(list: ListBuffer[Traffics_Statistic]): Unit = {

    var connection: Connection = null
    var pstmt: PreparedStatement = null

    try {
      connection = MySQLUtil.getConnection()

      connection.setAutoCommit(false) //设置手动提交

      val sql = "insert into Traffics_statistic(day,cms_id,traffics) values (?,?,?) "
      pstmt = connection.prepareStatement(sql)

      for (ele <- list) {
        pstmt.setString(1, ele.day)
        pstmt.setLong(2, ele.cmsId)
        pstmt.setLong(3, ele.traffics)
        pstmt.addBatch()
      }

      pstmt.executeBatch() // 执行批量处理
      connection.commit() //手工提交
    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtil.release(connection, pstmt)
    }
  }

  /**
    * 删除指定日期的数据
    */
  def deleteData(table: String, day: String): Unit = {

    var connection: Connection = null
    var pstmt: PreparedStatement = null

    try {
      connection = MySQLUtil.getConnection()

      // delete from table ....
      val deleteSQL = s"delete from $table where day = ?"
      pstmt = connection.prepareStatement(deleteSQL)
      pstmt.setString(1, day)
      pstmt.executeUpdate()

    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtil.release(connection, pstmt)
    }

  }

}
