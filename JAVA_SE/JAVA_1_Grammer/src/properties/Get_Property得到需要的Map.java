package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


/*
 * Author:Lijianbo
 * date:2016年4月29日
 * time:下午1:48:13
**/
public class Get_Property得到需要的Map {
    /*
     * 使用property读取classPath下的配置文件
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("1.properties"));
        String name = properties.getProperty("name");
        System.out.println(name);
    }

}
