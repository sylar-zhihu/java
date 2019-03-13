package io_use.IoUtilDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年11月2日:下午3:24:21
 * 程序作用:测试成功
**/
public class Demo1_readLines {

    @Test
    public void testRead() {
        try { 
            //  会自动去除换行符
            // windows默认的\不行，要改成/ 使用的是eclipse 的项目路径
            List<String> readLines = IOUtils.readLines(new FileInputStream("src/1.txt"));
            
            for (String string : readLines) {
                System.out.println(string);
            }
            // 使用文件相对路径 从当前java的目录读取
             readLines = IOUtils.readLines(Demo1_readLines.class.getResourceAsStream("1.txt"));
             for (String string : readLines) {
                 System.out.println(string);
             }
             // 从bin文件的根目录读取
             readLines = IOUtils.readLines(Demo1_readLines.class.getClassLoader().getResourceAsStream("1.txt"));
             for (String string : readLines) {
                 System.out.println(string);
             }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
