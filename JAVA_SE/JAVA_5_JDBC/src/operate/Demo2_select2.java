package operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 作者:Lijianbo
 * 日期:2016年6月28日:下午5:19:00
 * 程序作用:一次性 查询所有数据 不加where 加了where 有sql注入问题
 */
public class Demo2_select2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = DBUtilMysql_use.getConnection();
        // 3.通过连接对象获取操作sql语句Statement
        Statement st = con.createStatement();
        // 4.操作sql语句
        String sql = "select * from user";
        // 操作sql语句(select语句),会得到一个ResultSet结果集
        rs = st.executeQuery(sql);
        // 5.遍历结果集
        while (rs.next()) {
            int id = rs.getInt("id");
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
