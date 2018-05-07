package io_demo.console;

import java.util.Scanner;

/*
 * 作者:
 * 日期:2016年11月26日:下午2:21:49
 * 程序作用:从控制台读取数据 用空格分开
**/
public class System不推荐 {

    public static void main(String[] args) {
        // 接受控制台输入的对象
        Scanner s = new Scanner(System.in);
        String str;
        str = s.next();
        System.out.println(str);
    }

}
