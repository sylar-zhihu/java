package xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/*
 * 作者:Lijianbo
 * 日期:2016年6月27日:下午4:20:15
 * 程序作用:
**/
public class Select {

    /**
     * 对XPATH的支持
     */
    @Test
    public void getAuthor() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 方法1
        List<Node> list = document.selectNodes("/书架/书/作者");
        // 方法2
        // List<Node> list = document.selectNodes("//作者");
        Node author2 = list.get(1);
        System.out.println(author2.getText());
    }
}
