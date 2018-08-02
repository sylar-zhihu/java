package xml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年6月27日:下午3:08:00
 * 程序作用:使用dom4j去查询xml
**/
public class Search {

    /**
     * 获取第二本书作者
     * 
     * @throws Exception
     */
    @Test
    public void getAuther() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML，返回Document对象
        Document document = reader.read("src/book2.xml");
        // 获取根节点（书架标签）
        Element root = document.getRootElement();
        // 获取书的节点，获取第二本书
        // 多个同名节点用elements
        List<Element> books = root.elements("书");
        // 节点是从0开始的 第二本是下标是1
        Element book2 = books.get(1);
        // 获取作者的标签
        // 一个节点用element
        Element author2 = book2.element("作者");
        // 获取文本内容
        // 从element中得到文本内容
        System.out.println(author2.getText());// 岳不群
    }

}
