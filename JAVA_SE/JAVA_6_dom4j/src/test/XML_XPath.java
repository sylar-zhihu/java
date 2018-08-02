package test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XML_XPath {

	public static void main(String[] args) throws DocumentException {
		/*
		 * 介绍Xpath的使用 Xpath就是查询xml数据的一种语句
		 */
		// 根据xml的文件地址新建一个文件对象
		File file = new File("WebContent/book.xml");
		// 读取文件的类
		SAXReader xreader = new SAXReader();
		// 读取文件 进来是一个Document对象
		Document doc = xreader.read(file);
		// 得到根元素 是Element对象
		Element root = doc.getRootElement();
		// 建立查询语句 往里面填写查询语句就行 返回一个list
		// 任意一个位置的cbook节点 cid属性=002
		List<Element> list = root.selectNodes("//cbook[@cid='0002']");
		for (int i = 0; i < list.size(); i++) {
			Element node = (Element) list.get(i);
			// 输出元素
			System.out.println(node.getText());
		}
	}

}
