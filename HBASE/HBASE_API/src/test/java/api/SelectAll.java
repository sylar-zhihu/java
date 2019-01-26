package api;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
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
public class SelectAll {

    Configuration conf;

    Connection connection;

    Admin admin;

    @Before
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

    
    
  

    @After
    public void close() throws IOException {
        admin.close();
        connection.close();

    }

}
