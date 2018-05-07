package io_demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Class_static_write {

    // 定义一个static对象
    static BufferedWriter bw = null;

    // 在staitc 块里面初始化
    static {
        bw = null;
        FileWriter fw;
        try {
            fw = new FileWriter("src/io/company_write.txt");
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // 写入
        try {
            Class_static_write.bw.write("aaaa" + "\r\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                // 关闭
                Class_static_write.bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
