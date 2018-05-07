package io_demo.file;

import java.io.File;

/*
 * 作者:
 * 日期:2017年5月2日:下午7:33:05
 * 程序作用:
**/
public class FileDir {

    public static void main(String[] args) {
        // 得到当前文件夹的路径
        File file = new File("");
        String absolutePath = file.getAbsolutePath();
        // D:\eclipse_code\JAVA_Grammer 没用得到的是eclipse的根路径
        System.out.println(absolutePath);
        // D:\eclipse_code\JAVA_Grammer\bin\io_demo\file 得到当前文件的路径
        String str = FileDir.class.getResource("").getFile();
        file = new File(str);
        System.out.println(file.getAbsolutePath());
        // 得到当前文件夹的上一级目录 D:\eclipse_code\JAVA_Grammer\bin\io_demo
        str = FileDir.class.getResource("..").getFile();
        file = new File(str);
        System.out.println(file.getAbsolutePath());
        // 得到bin的路径 D:\eclipse_code\JAVA_Grammer\bin
        str = FileDir.class.getClassLoader().getResource("").getFile();
        file = new File(str);
        System.out.println(file.getAbsolutePath());
        // 通过拼接文件得到1.txt
        // 得到当前目录
        str = FileDir.class.getClassLoader().getResource("").getFile();
        file = new File(str+"/1.txt");
        System.out.println(file.getAbsolutePath());


    }

}
