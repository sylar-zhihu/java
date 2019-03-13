package io_use.IoUtilDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import io_use.getFile.Demo_2_readLinesAsOneString;

/*
 * 作者:
 * 日期:2016年11月26日:下午2:26:05
 * 程序作用:把整个文件读取为String对象
**/
public class Demo3_readlFileAsOneString {

    public static void main(String[] args) {
        // 把整个文件读取为String对象
        try {
            // 从bin文件的根目录读取 传入的是Stream
            String string = IOUtils.toString(Demo_2_readLinesAsOneString.class.getClassLoader().getResourceAsStream("1.txt"));
            System.out.println(string);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
