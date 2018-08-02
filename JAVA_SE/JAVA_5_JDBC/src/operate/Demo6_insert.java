package operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.JdbcUtils1;

//jdbc的crud操作
public class Demo6_insert {

    // 添加操作
    @Test
    public void addTest() {
        // 定义sql
        String sql = "insert into user values(null,'张三','123','zs@163.com')";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            con = DriverManager.getConnection("jdbc:mysql:///day17", "root", "abc");
            // 3.获取操作sql语句对象Statement
            st = con.createStatement();
            // 4.执行sql
            int row = st.executeUpdate(sql);
            if (row != 0) {
                System.out.println("添加成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
