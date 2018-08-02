package dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

public class DbUtilsTest1 {

    // select
    @Test
    public void selectTest() throws SQLException {
        String sql = "select * from account";
        QueryRunner runner = new QueryRunner();
        // 得到连接就可以直接查询
        Connection con = JdbcUtils.getConnection();
        List<Account> as = runner.query(con, sql, new ResultSetHandler<List<Account>>() {
            public List<Account> handle(ResultSet rs) throws SQLException {
                List<Account> as = new ArrayList<Account>();
                while (rs.next()) {
                    Account a = new Account();
                    a.setId(rs.getInt("id"));
                    a.setName(rs.getString("name"));
                    a.setMoney(rs.getDouble("money"));
                    as.add(a);
                }
                return as;
            }

        });
        for (Account a : as) {
            System.out.println(a);
        }
        DbUtils.close(con);
    }

    // add
    @Test
    public void addTest() throws SQLException {
        String sql = "insert into account values(null,?,?)";
        QueryRunner runner = new QueryRunner();
        int row = runner.update(JdbcUtils.getConnection(), sql, "张三", 1000d);
        System.out.println(row);
    }
}
