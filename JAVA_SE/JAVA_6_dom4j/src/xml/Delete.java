package xml;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年6月27日:下午3:45:40
 * 程序作用:
**/
public class Delete {
    /**
     * 删除子节点 删除第二本书下的猫节点
     */
    @Test
    public static void run4() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取猫
        Element book2 = (Element) root.elements("书").get(1);
        Element cat = book2.element("猫");
        // 通过猫获取猫的父节点
        // cat.getParent();
        // 通过父节点删除猫
        book2.remove(cat);
        // 回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 回写
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        writer.write(document);
        writer.close();
    }

}
