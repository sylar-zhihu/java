package io_demo;
import java.io.*;

public class Read_Write_Char {

	public static void main(String[] args) {
		// 读取流
		FileReader fr = null;
		// 输出流
		FileWriter fw = null;
		try {
			fr = new FileReader("D:/daima2/basic_grammer/src/io/test.txt");
			fw=new FileWriter("D:/daima2/basic_grammer/src/io/write_char.txt");
			int n = 0;// 记录读取到的字符数
			// 读取到内存 用的是char类型来接受
			char c[] = new char[1024];
			while ((n = fr.read(c)) != -1) {
				// 如果直接输出1024个 后面没有读取到的位置就是乱码
//				System.out.println(c);
				// 转成一个string就好了
				String s= new String(c,0,n);
				System.out.println(s);
				// 不指定位置容易乱码 再次写入是会覆盖文件的 而不是追加
				fw.write(c, 0, n);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
