package test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XML_Read {
	
	
	public static void main(String[] args) throws DocumentException {
		// 根据xml的文件地址新建一个文件对象
		File file=new File("WebContent/book.xml");
		// 读取文件的类
		SAXReader xreader =new SAXReader();
		// 读取文件 进来是一个Document对象
		Document doc=xreader.read(file);
		/*
		 * 一个一个标签获取
		 */
		// 得到根元素 是Element对象
		Element root=doc.getRootElement();
		//  得到当前节点的名字
		System.out.println(root.getName());// booklist
		// 得到当前标签下面名字已知的标签
		Element cbook=root.element("cbook");
		// 得到标签的名字
		System.out.println(cbook.getName());// cbook
		// 得到标签的内容
		System.out.println(cbook.getText());// 这里是cbook的内容
		// 得到标签中的属性
		Attribute cid= cbook.attribute("cid");
		// 得到属性的value
		System.out.println(cid.getText());// 0001
		// 得到属性的value
		System.out.println(cbook.attributeValue("cid"));// 0001
		/*
		 * 多个标签
		 */
		// 返回一个list 得到root下所有的名叫cbook的标签
		List<Element> list=root.elements("cbook");
		Iterator<Element> it=list.iterator();
		// 遍历
		while(it.hasNext()){
			Element temp=it.next();
		}
		
	}
}


