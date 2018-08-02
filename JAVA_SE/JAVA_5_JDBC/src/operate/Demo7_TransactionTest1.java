package operate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import operate.JdbcUtils;

//jdbc中事务操作
public class Demo7_TransactionTest1 {

	public static void main(String[] args) throws SQLException {

		// 修改id=2这个人的money=500;
		String sql = "update account set money=500 where id=2";
		Connection con = JdbcUtils.getConnection();
		con.setAutoCommit(false); //开启事务，相当于  start transaction;
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		//事务回滚
		//con.rollback();
		con.commit(); //事务提交
		st.close();
		con.close();
		
	}
}
