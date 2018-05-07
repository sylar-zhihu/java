package io_demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ex_read_line {

	public static void main(String[] args) {
		/*
		 * BufferedReader 可以按行读取 会自动去掉换行符号 需要创建一个 FileRead 传给BufferedReader的构造函数
		 */
		BufferedReader br = null;
		try {
			// 创建
			FileReader fr = new FileReader("D:/daima2/basic_grammer/src/io/test.txt");
			br = new BufferedReader(fr);
			// 循环读取到s中
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
