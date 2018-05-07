package io_demo;
import java.io.*;

public class Write_Byte {

	public static void main(String[] args) {
		File file=new File("D:/daima2/basic_grammer/src/io/write.txt");
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
			String s="李健博 hello world";
			// 把string转换为字符串 写入
			fos.write(s.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 关闭流
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
