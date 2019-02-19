package Spark_Streaming.homeWork.log1.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.io.IOException;

/**
 * HBase操作工具类：Java工具类建议采用单例模式封装
 */
public class HBaseUtilsTest {

    @Test
    // 测试连接hbase OK
    public void testConnection() {
        HTable table = HBaseUtils.getInstance().getTable("imooc_course_clickcount");
        System.out.println(table.getName().getNameAsString());
    }

    @Test
    // 测试INSERT INTO hbase
    public void testiNSERT() {
        String tableName = "imooc_course_clickcount";
        String rowkey = "20171111_88";
        String cf = "info";
        String column = "click_count";
        String value = "2";

        HBaseUtils.getInstance().put(tableName, rowkey, cf, column, value);
    }

    public static void main(String[] args) {

    }

}
