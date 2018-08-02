package operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//演示executeUpdate方法
public class Demo3_Update {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver"); // 加载mysql驱动
		String url = "jdbc:mysql:///day17";
		// 2.获取连接对象
		Connection con = DriverManager.getConnection(url, "root", "abc");
		// 3.通过连接对象获取操作sql语句Statement
		Statement st = con.createStatement();
		// 4.执行update语句
		int row = st.executeUpdate("update user set password='135' where id=1");
		System.out.println(row);
		// 6.释放资源
		st.close();
		con.close();
	}
}
