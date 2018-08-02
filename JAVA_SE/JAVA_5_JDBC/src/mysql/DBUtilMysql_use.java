package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 作者:Lijianbo
 * 日期:2016年7月17日:下午2:37:36
 * 程序作用:得到数据库连接,必须有这个其他的模块才能使用
**/
public class DBUtilMysql_use {

    // 得到和数据库的连接
    public static Connection getConnection() {
        
        String username = "root";
        String password = "";
        String urlMysql = "jdbc:mysql://localhost:3306/shop_1";
        
        Connection con = null;
        try {
            // mysql
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(urlMysql, username, password);
            
            // oracle
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            // con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:yuewei", "scott", "tiger"); 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return con;

    }

    // 关闭连接
    public static void close(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 关闭statement
    public static void close(Statement statement) {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 关闭PreparedStatement
    public static void close(PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 关闭ResultSet
    public static void close(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
