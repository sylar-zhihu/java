package io_demo.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.IOUtils;

/*
 * 作者:
 * 日期:2017年4月25日:下午8:54:52
 * 程序作用:从文件的某个位置开始读取
**/
public class Demo4_read_skip_offset {

    /**
     * 用途说明：写
     * 
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void write() throws FileNotFoundException, IOException {
        String string = "李1234567891";
        System.out.println(string.length());
        String string2 = "李1234";
        System.out.println(string2.length());
        // 想直接从文件读取aa456
        IOUtils.write(string+string2, new FileOutputStream(new File("src/io_demo/IoUtilDemo/1.txt")));


    }

    
    /**
     * 用途说明：
     * @throws IOException 
     */
    public static void read2() throws IOException{
        File file = new  File("src/io_demo/IoUtilDemo/1.txt") ;
        FileReader fileReader=new FileReader(file);
        char[] tempChar = new char[100];  
   
//        int pos = 0;//从下一个字节开始读  
//        int len = 2;//读几个字节  
//        stream.skip(pos); //跳过包含pos的字节数  
//        char[] b = new char[len];  
//        fileReader.read(cbuf, offset, length)
        fileReader.skip(11);
        fileReader.read(tempChar, 0, 5);
        System.out.println(new String(tempChar, 0, 5));
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        write();
        read2();
    }

}
