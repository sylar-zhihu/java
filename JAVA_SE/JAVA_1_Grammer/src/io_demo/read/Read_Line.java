package io_demo.read;

import java.io.*;

public class Read_Line {

    public static void main(String[] args) {
        /*
         * BufferedReader 可以按行读取 会自动去掉换行符号 需要创建一个 FileRead 传给BufferedReader的构造函数
         */
        BufferedReader br = null;
        /*
         * q BufferedWriter 可以按行写入 创建需要一个FileWrite
         */
        BufferedWriter bw = null;
        try {
            // 创建
            FileReader fr = new FileReader("D:/daima2/basic_grammer/src/io/test.txt");
            FileWriter fw = new FileWriter("D:/daima2/basic_grammer/src/io/write_line.txt");
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // 循环读取 会去除/r/n
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
                // 自己加入换行 和python一样
                bw.write(s + "\r\n");
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
