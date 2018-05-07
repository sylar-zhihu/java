package io_demo.IoUtilDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

/*
 * 作者:
 * 日期:2016年11月26日:下午1:37:03
 * 程序作用:
**/
public class Demo2_writeLines {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("hello");
        lines.add("list");
        lines.add("to");
        lines.add("file");
        OutputStream os;
        try {
            os = new FileOutputStream("src/test.txt");
            // IOUtils.LINE_SEPARATOR 换行符 /r/n
            IOUtils.writeLines(lines, IOUtils.LINE_SEPARATOR, os);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
