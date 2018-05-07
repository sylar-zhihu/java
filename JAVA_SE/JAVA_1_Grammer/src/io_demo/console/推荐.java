package io_demo.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 作者:
 * 日期:2016年12月7日:下午1:46:32
 * 程序作用:用回车分割
**/
public class 推荐 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            while (true) {
                BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
                String str;

                str = strin.readLine();

                System.out.println(str);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
