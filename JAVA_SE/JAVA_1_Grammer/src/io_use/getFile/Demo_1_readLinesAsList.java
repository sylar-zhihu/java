package io_use.getFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年11月2日:下午3:24:21
 * 程序作用:测试成功
**/
public class Demo_1_readLinesAsList {

    @Test
    public void testRead() {
        try {

            // 从bin文件的根目录读取 传入的是Stream
            List<String> readLines = IOUtils.readLines(Demo_1_readLinesAsList.class.getClassLoader().getResourceAsStream("1.txt"));
            for (String string : readLines) {
                System.out.println(string);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
