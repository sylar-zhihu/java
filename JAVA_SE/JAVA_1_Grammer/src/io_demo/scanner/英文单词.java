package io_demo.scanner;

import java.util.Scanner;

/*
 * 作者:
 * 日期:2016年12月6日:下午4:29:22
 * 程序作用:scanner会拆分空格但是逗号去不掉，感覺沒啥用
**/
public class 英文单词 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner("open-source software.");
        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(next.trim());// software.

        }
        scanner.close();

    }

}
