package operate;

/*
 * 作者:Lijianbo
 * 日期:2016年6月28日:下午5:19:00
 * 程序作用:连接mysql数据库
 * 需要事先执行的语句
 *              create table user(
                   id int primary key auto_increment,
                   username varchar(20) unique not null,
                   password varchar(20) not null,
                   email varchar(40) not null
                );
                
                INSERT INTO USER VALUES(NULL,'tom','123','tom@163.com');
                INSERT INTO USER VALUES(NULL,'fox','123','fox@163.com');
 * demo1 没人用
 * demo2 常用
**/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.Driver;

import utilsOracleMysql.DBUtilMysql;
import utilsOracleMysql.DBUtilOracle;
import utilsOracleMysql.FactoryDBUtil;

public class Demo1_select {

    public static void main(String[] args) throws SQLException {
        Connection con = DBUtilOracle.getConnection();
        // 验证是否连接正确
        System.out.println(con);
        // 3.通过连接对象获取操作sql语句Statement
        Statement st = con.createStatement();
        // 4.操作sql语句
        String sql = "select * from user";
        // 操作sql语句(select语句),会得到一个ResultSet结果集
        ResultSet rs = st.executeQuery(sql);
        // 5.遍历结果集
        // boolean flag = rs.next(); // 向下移动，返回值为true，代表有下一条记录.
        // int id = rs.getInt("id");
        // String username=rs.getString("username");
        // System.out.println(id);
        // System.out.println(username);
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");

            System.out.println(id + "  " + username + "  " + password + "  " + email);
        }
        // 6.释放资源 三个顺序不能改
        dButil.close(rs);
        dButil.close(st);
        dButil.close(con);
    }
}
