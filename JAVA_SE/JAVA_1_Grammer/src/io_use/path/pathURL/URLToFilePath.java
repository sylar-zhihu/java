package io_use.path.pathURL;

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
public class URLToFilePath {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        
        URL resource = URLToFilePath.class.getClassLoader().getResource("");
        System.out.println(resource);
        // URL to FilePath
        String filePath = resource.getPath();
        System.out.println(filePath);// /D:/Git_Code_2019/JAVA_SE/JAVA_1_Grammer/target/classes/
        
        
    }
}
