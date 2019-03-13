package io_use.path;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/*
 * 作者:
 * 日期:2017年3月16日:下午4:14:02
 * 程序作用:
**/
public class Old {
    
    

    public static void main(String[] args) throws FileNotFoundException {
        
        // 得到classPath的根目录
         getBaseClassPath();
        
         // 得到classPath下面的文件
       
        URL resource2;
        InputStream resourceAsStream;
        getClassPathFile();

        // 得到当前路径的文件的路径下的文件 ../表示上一级文件夹
        resource2 = Old.class.getResource("1.txt");
        System.out.println(resource2);
        // 或者直接得到inputString
        resourceAsStream = Old.class.getResourceAsStream("1.txt");
    }

    private static void getClassPathFile() {
        URL resource2 = Old.class.getResource("1.txt");
        System.out.println(resource2);
        // 或者直接得到inputString
        InputStream resourceAsStream = Old.class.getResourceAsStream("1.txt");
    }

    private static void getBaseClassPath() {
        // bin文件目录，也就是classPath根目录
        // 得到的是bin文件的目录 这里得到的是url对象 不能直接new file对象
        URL resource = Old.class.getClassLoader().getResource("");
        System.out.println(resource);// file:/D:/Git_Code_2019/JAVA_SE/JAVA_1_Grammer/target/classes/
    }

}
