package io_use.path.pathURL;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

/*
 * 作者:
 * 日期:2017年3月16日:下午4:14:02
 * 程序作用:
**/
public class GetCurrentClassPathURL {
    
    

    public static void main(String[] args) throws FileNotFoundException {
      
        URL resource2 = GetCurrentClassPathURL.class.getResource("");
        System.out.println(resource2);// 会多一个path目录
  
    }
 

}
