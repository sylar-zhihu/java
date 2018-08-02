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
 * 日期:2016年6月27日:下午3:47:35
 * 程序作用:
**/
public class Update {
    /**
     * 修改文本内容
     */
    @Test
    public static void run5() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取狗的节点
        Element book2 = (Element) root.elements("书").get(1);
        Element dog = book2.element("狗");
        dog.setText("小狗");
        // 回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        writer.write(document);
        writer.close();
    }

}
