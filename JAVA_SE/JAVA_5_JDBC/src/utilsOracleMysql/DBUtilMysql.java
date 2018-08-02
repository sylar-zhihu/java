package utilsOracleMysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 作者:Lijianbo
 * 日期:2016年7月17日:下午2:37:36
 * 程序作用:
**/
public class DBUtilMysql {

    // 得到和数据库的连接
    public static Connection getConnection() throws IOException {
        Properties properties=new Properties();
        properties.load(DBUtilMysql.class.getClassLoader().getResourceAsStream("mysql.property"));
        
        String username = (String) properties.get("username");
        String password = (String) properties.get("password");;
        String url = (String) properties.get("url");;
        
        Connection con = null;
        try {
            // mysql
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            
         
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
