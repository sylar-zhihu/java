package operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.domain.User;
import cn.itcast.exception.LoginException;
import cn.itcast.utils.JdbcUtils;

/*
 * 作者:Lijianbo
 * 日期:2016年6月28日:下午5:19:00
 * 程序作用:一次性 查询所有数据 存在sql注入问题
 */
public class Demo2_select3_use implements UserDao {

    // 使用PreparedStatement来完成操作，它可以解决sql注入.
    public User findUser(User user) throws SQLException {

        // 1.sql语句
        String sql = "select * from user where username=? and password=?";

        // 2.执行sql
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = JdbcUtils.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            rs = pst.executeQuery();// 无参数

            if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息，就将结果集中的信息封装到User对象中.
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                return u;
            }

        } finally {
            try {
                JdbcUtils.closeResultSet(rs);
                JdbcUtils.closeStatement(pst);
                JdbcUtils.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
