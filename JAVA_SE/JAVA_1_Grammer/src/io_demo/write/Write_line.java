package io_demo.write;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Write_line {

    public static void main(String[] args) {
        /*
         * BufferedWriter 可以按行写入 创建需要一个FileWrite
         */
        BufferedWriter bw = null;
        try {
            ArrayList<String> al = new ArrayList<String>();
            al.add("a");
            al.add("b");
            // 创建
            FileWriter fw = new FileWriter("D:/daima2/basic_grammer/src/io/write_line.txt");
            bw = new BufferedWriter(fw);
            // 循环写入
            Iterator<String> it = al.iterator();
            while (it.hasNext()) {
                bw.write(it.next() + "\r\n");
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
