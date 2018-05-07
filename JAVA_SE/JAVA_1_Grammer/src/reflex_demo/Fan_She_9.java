package reflex_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class Fan_She_9 {
	/*
	 * 从配置文件读取信息
	 * 然后反射 模拟框架
	 */
	public static void main(String[] args) throws Exception {
		// 两种得到配置文件的方法
		// 相对路径 可读可写
		InputStream inputStream = new FileInputStream("src/basic_grammer/configure.property");
		// 这一种是使用类加载器 从项目根目录读取 和类放在一起可以直接找到 但是只能读取
		InputStream inputStream2=Fan_She_9.class.getClassLoader().getResourceAsStream("basic_grammer/configure.property");
		// 从类文件的目录读取
		InputStream inputStream3=Fan_She_9.class.getResourceAsStream("configure.property");
		// 直接从inputStream中读取键值对
		Properties properties = new Properties();
		properties.load(inputStream);
		inputStream.close();
		// 得到文本中className对应的值
		String className=properties.getProperty("className");
		// 得到对象
		Collection collection = (Collection)Class.forName(className).newInstance();
		collection.add("1");
		System.out.println(collection.size());

	}

}
