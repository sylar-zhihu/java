package operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//ResultSet介绍

public class Demo4_ResultSet {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver"); // 加载mysql驱动
        String url = "jdbc:mysql:///day17";
        // 2.获取连接对象
        Connection con = DriverManager.getConnection(url, "root", "abc");
        // 3.通过连接对象获取操作sql语句Statement
        Statement st = con.createStatement();
        // 4.操作sql语句
        String sql = "select * from user";
        ResultSet rs = st.executeQuery(sql);
        // 5.遍历结果集
        while (rs.next()) {
            String id = rs.getString("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            System.out.println(id + "  " + username + "  " + password + "  " + email);
        }
        // 6.释放资源
        rs.close();
        st.close();
        con.close();
    }
}
