package io_demo.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

/*
 * 作者:
 * 日期:2017年5月13日:上午10:08:55
 * 程序作用:
**/
public class EndWrite {

    public static void main(String[] args) {
        // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
        String path = EndWrite.class.getResource("").getFile();
        System.out.println(path);
        try {
             path=path+"1.txt";
             System.out.println(path);
             System.out.println(new File(path).getAbsolutePath());
            FileWriter writer = new FileWriter(new File(path), true);
            String str="aaaa";
            for (int i = 0; i < 10000; i++) {
                writer.write(str);
                
            }
            writer.close();
            System.out.println("down");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
