package operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utilsOracleMysql.DBUtilOracle;
import utilsOracleMysql.FactoryDBUtil;

/*
 * 作者:Lijianbo
 * 日期:2016年7月17日:下午2:37:36
 * 程序作用:批量插入
**/
public class Demo6_insert_Obj {

    public static void main(String[] args) throws SQLException {

        Connection con = null;
        PreparedStatement pst = null;
        // 向person表中插入1000条数据
        try {
            // 用来记录时间
            long l;
            // 插入语句
            String sql = "insert into WD_IDFVALUE (WORDID,INDICATORVALUE) values(?,?)";
            con = DBUtilOracle.getConnection();
            pst = con.prepareStatement(sql);

            l = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() - l);
            for (int i = 1; i <= 100; i++) {
                // 设置插入的参数
                pst.setInt(1, i);
                pst.setInt(2, i);
//                pst.setString(parameterIndex, x);
                pst.addBatch();
                // 一段时间执行一次
                if (i % 1000 == 0) {
                    pst.executeBatch();
                    pst.clearBatch(); // 清空缓存。
                }

            }
            System.out.println("down");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 执行批处理
            pst.executeBatch();
            pst.close();
            con.close();

        }

    }
}
