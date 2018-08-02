package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XML_Write {

	public static void main(String[] args) throws IOException {
		/*
		 * 介绍XML的写操作
		 */
		// 创建一个文档
		Document doc = DocumentHelper.createDocument();
		// 在文档中加入一个标签 第一个是根标签
		Element booklist = doc.addElement("booklist");
		// 添加注释
		booklist.addComment("写入注释");
		// 继续添加标签
		Element cbook=booklist.addElement("cbook");
		// 添加元素  <cbook>first cbook</cbook> 中间的就是元素
		cbook.addText("first cbook");
		// 添加属性  <cbook cid="0001">
		cbook.addAttribute("cid", "0001");
		
		// 设置格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码格式
		format.setEncoding("UTF-8");
		// 新建文件
		File file = new File("mybook.xml");
		// 写入对象
		XMLWriter xwriter = new XMLWriter(new FileOutputStream(file), format);
		// 用写入对象写入文档
		xwriter.write(doc);
		// 关闭写入对象
		xwriter.close();
	}

}
