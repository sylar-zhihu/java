package operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilsOracleMysql.DBUtilMysql;

/*
 * 作者:Lijianbo
 * 日期:2016年7月17日:下午3:06:21
 * 程序作用:
**/
public class Demo8_Prepare_Statement {

    public void add(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtilMysql.getConnection();
            // 查询传入用户是否存在
            String sql = "select count(*) from t_user where username=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();

            sql = "insert into t_user (username,password,nickname,type,status) value (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNickname());
            ps.setInt(4, user.getType());
            ps.setInt(5, user.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtilMysql.close(rs);
            DBUtilMysql.close(ps);
            DBUtilMysql.close(con);
        }
    }

}
