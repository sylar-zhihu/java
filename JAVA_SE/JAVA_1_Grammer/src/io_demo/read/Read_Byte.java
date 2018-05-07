package io_demo.read;

import java.io.*;// io和这个包相关

/*
 * 作者:
 * 日期:2016年12月6日:上午9:50:37
 * 程序作用:file 本身没有读取的方法 要使用FileInputStream 类来读取
**/
public class Read_Byte {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/daima2/basic_grammer/src/io/test.txt");
        // 必须要在try外面定义这个对象 FileInputStream fis=null不然在finally里面没法关闭
        FileInputStream fis = null;
        try {
            // 用FileInputStream(file)来读取
            fis = new FileInputStream(file);
            int n = 0;
            // 相当于缓存 每次读取这里么多
            byte[] bytes = new byte[1024];
            // 一次最多读取 bytes 这个数组大小 在while中不停的读取 返回读了多少个字符，用n保存。换行也会一起读进来 如果读取到结尾了返回-1
            while ((n = fis.read(bytes)) != -1) {
                // 会进来一次 把字节转成string
                String s = new String(bytes, 0, n);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 一定要关闭文件流必须放在这 因为有异常前面的代码可能没有执行
            fis.close();
        }

    }
}
