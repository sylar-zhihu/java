package io_demo.path;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/*
 * 作者:
 * 日期:2017年5月2日:下午3:13:53
 * 程序作用:java 中的url和file不是同一个东西
 * url是可以认为是网址
 * 所以尽量不用url
**/
public class UrlAndFile {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        // 得到url
        URL resource = UrlAndFile.class.getClassLoader().getResource("");
        //  file:/D:/eclipse_code/JAVA_Grammer/bin/   带有file无法直接new file
        System.out.println(resource); 
        // 这样可以直接得到fileDir  getPath()
        String str = UrlAndFile.class.getClassLoader().getResource("").getPath();
        File file = new File(str);
        // D:\eclipse_code\JAVA_Grammer\bin
        System.out.println(file.getAbsolutePath());
        //  file:/D:/eclipse_code/JAVA_Grammer/bin/ url没法new File  带有file无法直接new file
        System.out.println(str);
        // 转换成 file 形式
         file = new File(resource.toURI());
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        // url 转换成file形式
        URL url=file.toURI().toURL(); 
        
    }
}
