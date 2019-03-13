package io_use.getPathAsStream;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/*
 * 作者:
 * 日期:2017年3月16日:下午4:14:02
 * 程序作用:inputStream 可以直接去读文件
**/
public class GetClassPathAsStream {
    
    

    public static void main(String[] args) throws FileNotFoundException {
        // 使用getClassLoader 得到的是classpath跟目录
        // 得到bin文件目录，也就是classPath根目录
        // 得到的是bin文件的目录 这里得到的是url对象 不能直接new file对象
        InputStream inputStream = GetClassPathAsStream.class.getClassLoader().getResourceAsStream("");
        System.out.println(inputStream);// file:/D:/Git_Code_2019/JAVA_SE/JAVA_1_Grammer/target/classes/
   
    }

  



}
