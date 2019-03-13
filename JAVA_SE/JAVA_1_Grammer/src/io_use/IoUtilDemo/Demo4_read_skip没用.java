package io_use.IoUtilDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

/*
 * 作者:
 * 日期:2017年5月3日:上午9:17:30
 * 程序作用:基本没用 无法跳过
**/
public class Demo4_read_skip没用 {
    
    public static void main(String[] args) {
        char[] tempChar= new char[10000];
        String path = Demo4_read_skip没用.class.getResource("1.txt").getPath();
        // 可以跳过的read // read(Reader input, char[] buffer, int offset, int length)
        // 这个offset 是指的是在 char[]中的偏移位置 没啥用，从二开始前面就会有两个乱码 
        // offset - initial offset into buffer
        try {
            IOUtils.read(new FileReader(new File(path)), tempChar, 0, 5);
            System.out.println(String.valueOf(tempChar));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
