package io_demo.path;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/*
 * 作者:
 * 日期:2017年3月16日:下午4:14:02
 * 程序作用:
**/
public class Path {

    public static void main(String[] args) throws FileNotFoundException {
        // bin文件
        // 得到的是bin文件的目录 这里得到的是url对象 不能直接new file对象
        URL resource = Path.class.getClassLoader().getResource("");
        System.out.println(resource);// file:/D:/eclipse_code/JAVA_Grammer/bin/
        // 得到bin文件里面的文件
        URL resource2 = Path.class.getResource("1.txt");
        System.out.println(resource2);
        // 或者直接得到inputString
        InputStream resourceAsStream = Path.class.getResourceAsStream("1.txt");

        // 得到当前路径的文件的路径下的文件 ../表示上一级文件夹
        resource2 = Path.class.getResource("1.txt");
        System.out.println(resource2);
        // 或者直接得到inputString
        resourceAsStream = Path.class.getResourceAsStream("1.txt");
    }

}
