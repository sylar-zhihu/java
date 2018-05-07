package io_demo.file;

import java.io.File;

/*
 * 作者:
 * 日期:2017年5月2日:下午7:55:41
 * 程序作用:
**/
public class GetResource {

    public static void main(String[] args) {
        // 当前文件夹下的1.txt文件
        String str = FileDir.class.getResource("1.txt").getFile();
        File file = new File(str);
        System.out.println(file.getAbsolutePath());
        // ""为当前文件夹
         str = FileDir.class.getResource("").getFile();
         file = new File(str);
        System.out.println(file.getAbsolutePath());
    }

}
