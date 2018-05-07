package io_demo.file;

import java.io.File;

/*
 * 作者:
 * 日期:2016年12月6日:上午10:03:00
 * 程序作用:
**/
public class 文件夹 {
    
    public static void main(String[] args) {
        File file=new File("dd");
        if(!file.isDirectory()){// 如果不存在
            file.mkdir();
        }
        // 列出文件夹下面的所有文件
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            System.out.println(file2.getName());
            
        }
        
        
    }

}
