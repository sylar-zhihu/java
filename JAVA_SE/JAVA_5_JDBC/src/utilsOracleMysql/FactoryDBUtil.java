package utilsOracleMysql;


/*
 * 作者:Lijianbo
 * 日期:2016年7月17日:下午4:05:47
 * 程序作用:
**/
public class FactoryDBUtil {
    private static DBUtilOracle dbUtil = new DBUtilOracle();

    public static DBUtilOracle getOracleDButil() {
        return dbUtil;
    }

}
