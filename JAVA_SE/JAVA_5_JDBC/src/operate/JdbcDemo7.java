package operate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtils;

//滚动结果集
public class JdbcDemo7 {

	public static void main(String[] args) throws SQLException {

		// 1.得到一个Connection
		Connection con = JdbcUtils.getConnection();

		// 2.得到一个执行sql语句Statement
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		// 3.执行sql，得到结果集
		ResultSet rs = st.executeQuery("select * from user");

		// 4.定位
		rs.absolute(3);

		// System.out.println(rs.getInt("id") + "  " +
		// rs.getString("username"));

		// rs.afterLast();
		//
		// while (rs.previous()) {
		// System.out.println(rs.getInt("id") + "  "
		// + rs.getString("username"));
		// }
		
		rs.updateString("password", "456");
		rs.updateRow();
		
		

		// 5.关闭
		rs.close();
		st.close();
		con.close();
	}
}
