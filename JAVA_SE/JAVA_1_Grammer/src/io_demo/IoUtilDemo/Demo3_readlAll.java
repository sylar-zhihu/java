package io_demo.IoUtilDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/*
 * 作者:
 * 日期:2016年11月26日:下午2:26:05
 * 程序作用:把整个文件读取为String对象
**/
public class Demo3_readlAll {

    public static void main(String[] args) {
        // 把整个文件读取为String对象
        String readFileToString;
        try {
            readFileToString = FileUtils.readFileToString(new File("test.txt"));
            System.out.println(readFileToString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
