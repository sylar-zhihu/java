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
import org.apache.hadoop.hbase.NamespaceNotFoundException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
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
public class HBASE_APIS {

    Configuration conf;

    Connection connection;

    Admin admin;

    public void init() throws IOException {
        // 使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        // 设置ZK的地址
        conf.set("hbase.zookeeper.quorum", "192.168.18.101");
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        // 获取连接对象
        connection = ConnectionFactory.createConnection(conf);
        // 得到admin
        admin = connection.getAdmin();
    }

    /**
     * 作者： 用途说明：判断表是否存在
     * 
     * @param tableName
     * @return
     * @throws Exception
     */
    public boolean tableExist(String tableName) throws Exception {

        return admin.tableExists(TableName.valueOf(tableName));

    }

    /**
     * 作者： 用途说明：创建命名空间，存在就返回，不存在就创建
     * 
     * @param ns
     * @throws Exception
     */
    public void createNameSpace(String ns) throws Exception {

        // 如果不存在就创建
        try {
            admin.getNamespaceDescriptor(ns);
        } catch (NamespaceNotFoundException e) {
            // 创建
            NamespaceDescriptor build = NamespaceDescriptor.create(ns).build();
            admin.createNamespace(build);
        }

    }

    /**
     * 作者： 用途说明：创建表
     * 
     * @param tableName
     * @param columnFamilys 列族名
     * @throws Exception
     */
    public void createTable(String tableName, String... columnFamilys) throws Exception {
        if (tableExist(tableName)) {
            System.out.println("表已经存在");
            return;
        }

        // 表的dec
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        for (String columnName : columnFamilys) {
            // 创建列族
            HColumnDescriptor columnFamily = new HColumnDescriptor(columnName);
            // 加入表
            table.addFamily(columnFamily);
        }
        // 创建表
        admin.createTable(table);

    }

    /**
     * 作者： 用途说明：删除表
     * 
     * @param tableName
     * @throws Exception
     */
    public void deleteTable(String tableName) throws Exception {
        if (tableExist(tableName)) {
            // 标记为不可用
            admin.disableTable(TableName.valueOf(tableName));
            // 删除表
            admin.deleteTable(TableName.valueOf(tableName));
            System.out.println("表" + tableName + "删除成功！");
        } else {
            System.out.println("表" + tableName + "不存在！");
        }

    }

    /**
     * 作者：sylar-李 时间：2019年1月26日 下午1:42:56 用途说明：插入一行数据
     * 
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @param value
     * @throws Exception
     */
    public void insertOneRow(String tableName, String rowKey, String columnFamily, String column, String value) throws Exception {
        // 是否存在
        if (!tableExist(tableName)) {
            System.out.println("表不存在");
            return;
        }
        // 获取表对象
        Table hTable = connection.getTable(TableName.valueOf(tableName));
        // 向表中插入数据
        Put put = new Put(Bytes.toBytes(rowKey));
        // 向Put对象中组装数据
        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
        hTable.put(put);
        hTable.close();
        System.out.println("插入数据成功");

    }

    /**
     * 作者：sylar-李 时间：2019年1月26日 下午1:50:08 用途说明：
     * 
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @return
     * @throws Exception
     */
    public Result selectOneRow(String tableName, String rowKey, String columnFamily, String column) throws Exception {
        // 是否存在
        if (!tableExist(tableName)) {
            System.out.println("表不存在");
            return null;
        }
        // 得到表
        Table table = connection.getTable(TableName.valueOf(tableName));
        // 得到数据
        Get get = new Get(Bytes.toBytes(rowKey));
        // get.setMaxVersions();显示所有版本
        // get.setTimeStamp();显示指定时间戳的版本
        Result result = table.get(get);
        // for (Cell cell : result.rawCells()) {
        // System.out.println("行键:" + Bytes.toString(result.getRow()));
        // System.out.println("列族" + Bytes.toString(CellUtil.cloneFamily(cell)));
        // System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
        // System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
        // System.out.println("时间戳:" + cell.getTimestamp());
        // }
        table.close();
        return result;
    }

    /**
     * 作者：sylar-李 时间：2019年1月26日 下午1:57:00 用途说明：
     * 
     * @param tableName
     * @param rowKey
     * @throws Exception
     */
    public void deleteOneRow(String tableName, String rowKey) throws Exception {
        // 是否存在
        if (!tableExist(tableName)) {
            System.out.println("表不存在");
            return;
        }
        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        table.delete(delete);
        table.close();
    }

    /**
     * 作者：sylar-李 时间：2019年1月26日 下午2:01:47 用途说明：
     * 
     * @param tableName
     * @param rowKey
     * @param columnFamily
     * @param column
     * @throws Exception
     */
    public void deleteOneRowColumnFamily(String tableName, String rowKey, String columnFamily, String column) throws Exception {
        // 是否存在
        if (!tableExist(tableName)) {
            System.out.println("表不存在");
            return;
        }

        Table table = connection.getTable(TableName.valueOf(tableName));
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        delete.addColumns(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
        table.delete(delete);
        table.close();

    }

    /**
     * 作者：sylar-李
     * 时间：2019年1月26日 下午2:13:42 
     * 用途说明：
     * @param tableName
     * @return
     * @throws Exception
     */
    public ResultScanner selectAll(String tableName) throws Exception {
        // 是否存在
        if (!tableExist(tableName)) {
            System.out.println("表不存在");
            return null;
        }
        // 得到table
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        ResultScanner results = table.getScanner(scan);
//        for (Result result : results) {// 不同的rowKey
//            Cell[] cells = result.rawCells();
//            for (Cell cell : cells) {// 同一个rowkey有不同的cell
//                // 得到rowkey
//                System.out.println("行键:" + Bytes.toString(CellUtil.cloneRow(cell)));
//                // 得到列族
//                System.out.println("列族" + Bytes.toString(CellUtil.cloneFamily(cell)));
//                System.out.println("列:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
//                System.out.println("值:" + Bytes.toString(CellUtil.cloneValue(cell)));
//
//            }
//
//        }
        table.close();
        return results;

    }

    public void close() throws IOException {
        admin.close();
        connection.close();

    }

}
