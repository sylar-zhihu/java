package xml;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年6月27日:下午3:28:47
 * 程序作用:在指定位置添加元素，通过操作list来实现
**/
public class AddNode2 {
    /**
     * 在第二本书的作者标签之前添加团购价的标签
     */
    @Test
    public void addNode() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取第二本书
        Element book2 = (Element) root.elements("书").get(1);
        // 获取书下的所有子节点，返回List集合
        List<Element> list = book2.elements();
        // 创建元素对象 DocumentHelper.createElement("狗")
        Element dog = DocumentHelper.createElement("狗");
        // 设置对象的文本
        dog.setText("大狗");
        // list.add(index,Element); 通过list指定位置
        list.add(1, dog);
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 回写
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        writer.write(document);
        writer.close();
    }

}
