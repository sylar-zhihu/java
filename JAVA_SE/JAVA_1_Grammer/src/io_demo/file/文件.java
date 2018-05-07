package io_demo.file;

import java.io.File;
import java.io.IOException;

/*
 * 作者:
 * 日期:2016年12月6日:上午9:50:37
 * 程序作用:
**/
public class 文件 {

    public static void main(String[] args) throws IOException {
        // 得到一个文件

        File file = new File("D:/1.txt");// 绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        boolean createNewFile = file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        file = new File("src/test.txt");// 相对路径

        // 得到名字
        file.getName();
        // 得到文件路径
        System.out.println(file.getAbsolutePath());// D:\code\eclipse_code\JAVA_Grammer\src\test.txt
        // 得到文件的字节
        System.out.println(file.length());// 23
        // 创建文件
        if (!file.exists()) {// 如果不存在就创建
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
