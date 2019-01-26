package api;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * 作者:
 * 日期:2019年1月23日:下午9:03:48
 * 程序作用:
**/
public class HBASE_APIS_Test {

    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:43:34 
     * 用途说明：测试成功
     * @throws Exception
     */
    @Test
    public void testCreateTable() throws Exception {
        String tableName = "student";
        String[] columnFamilys = { "aa", "bb" };
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        hBASE_APIS.createTable(tableName, columnFamilys);
        hBASE_APIS.close();

    }
    
    
    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:43:17 
     * 用途说明：测试成功
     * @throws Exception
     */
    @Test
    public void testDeleteTable() throws Exception {
        String tableName = "student";
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        hBASE_APIS.deleteTable(tableName);
        hBASE_APIS.close();
    }
    

    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:43:44 
     * 用途说明：测试成功
     * @throws Exception
     */
    @Test
    public void testIsTableExist() throws Exception {
        String tableName = "student";
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        System.out.println(hBASE_APIS.tableExist(tableName));
        hBASE_APIS.close();

    }

    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:43:51 
     * 用途说明：测试成功
     * @throws Exception
     */
    @Test
    public void testCreateNameSpace() throws Exception { 
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        hBASE_APIS.createNameSpace("testNs");
        hBASE_APIS.close();

    }
    
    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:46:31 
     * 用途说明：OK
     * @throws Exception
     */
    @Test
    public void testInsertOneRow() throws Exception { 
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        hBASE_APIS.insertOneRow("student", "1", "aa", "aa_name", "li");
        hBASE_APIS.insertOneRow("student", "2", "aa", "aa_name", "li");
        hBASE_APIS.close();

    }
    
    
    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:51:21 
     * 用途说明：OK
     * @throws Exception
     */
    @Test
    public void testSelectOneRow() throws Exception { 
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        Result result = hBASE_APIS.selectOneRow("student", "1", "aa", "aa_name");
        for (Cell cell : result.rawCells()) {
            System.out.println("行键:" + Bytes.toString(result.getRow()));
            System.out.println("列族" + Bytes.toString(CellUtil.cloneFamily(cell)));
            System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
            System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
            System.out.println("时间戳:" + cell.getTimestamp());
        }
        hBASE_APIS.close();
    }
    
    
    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午1:59:22 
     * 用途说明：OK
     * @throws Exception
     */
    @Test
    public void testDeleteOneRow() throws Exception { 
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        hBASE_APIS.deleteOneRow("student", "1");
        hBASE_APIS.close();
    }
    
    
    
    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午2:12:23 
     * 用途说明：OK
     * @throws Exception
     */
    @Test
    public void testDeleteOneRowColumnFamily() throws Exception { 
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        hBASE_APIS.deleteOneRowColumnFamily("student", "1", "aa", "aa_name");
        hBASE_APIS.close();
    }
    
    
    @Test
    public void testSelectAll() throws Exception { 
        HBASE_APIS hBASE_APIS = new HBASE_APIS();
        hBASE_APIS.init();
        ResultScanner results = hBASE_APIS.selectAll("student");
        for (Result result : results) {// 不同的rowKey
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {// 同一个rowkey有不同的cell
                // 得到rowkey
                System.out.println("行键:" + Bytes.toString(CellUtil.cloneRow(cell)));
                // 得到列族
                System.out.println("列族" + Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));

            }

        }
        hBASE_APIS.close();
    }
    
    
    
    
    
    
    
    

}
