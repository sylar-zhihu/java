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
 * 日期:2016年6月27日:下午3:09:32
 * 程序作用:在末尾添加节点
**/
public class AddLastNode {

    /**
     * 在第二本书下添加子节点
     */
    @Test
    public  void addNode() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML，返回Document对象
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取第二本书
        Element book2 = (Element) root.elements("书").get(1);
        // 可以直接在第二本书下添加子节点，设置文本内容 这里默认是添加到最后
        book2.addElement("猫").setText("我是猫");
        //======== 回写 写入硬盘中 上面是在内存中操作
        // 创建漂亮的格式 会把所有的格式标准化，不仅仅是新写入的数据标准化
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 压缩的格式 全部成一行
        // OutputFormat format = OutputFormat.createCompactFormat();
        // 设置编码
        format.setEncoding("UTF-8");
        // format.setEncoding("GBK");
        // 回写类
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        // 回写了文档对象
        writer.write(document);
        // 关闭流
        writer.close();
    }

}
