package tomcat;

import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/*
 * 作者:
 * 日期:2019年3月13日:下午5:38:15
 * 程序作用:
**/
public class XMLUtil {
    
    static String fPath = "WEB-INF/web.xml";

    // key serlvet：name value：对应class
    static HashMap<String, String> servleNameClassMap = new HashMap<>();

    // key :对应url  value：serlvet name
    static HashMap<String, String> UrlservleNameMap = new HashMap<>();
    // 

    public static void init() throws DocumentException {
        // 得到xml文件
        
        SAXReader saxReader = new SAXReader();
        // 读取
        Document document = saxReader.read(XMLUtil.class.getClassLoader().getResourceAsStream(fPath));
        // System.out.println(document);
        // 获取多个servlet
        List<Element> servletNodes = document.selectNodes("/web-app/servlet");
        // 遍历node 填充servleNameClassMap
        for (Element servletNode : servletNodes) {
            //
            String servletName = servletNode.selectSingleNode("servlet-name").getStringValue();
            String servletClass = servletNode.selectSingleNode("servlet-class").getStringValue();
            servleNameClassMap.put(servletName, servletClass);
        }
        // 遍历node 填充servleNameUrlMap
        servletNodes = document.selectNodes("/web-app/servlet-mapping");
        // 遍历node 填充servleNameClassMap
        for (Element servletNode : servletNodes) {
            //
            String servletName = servletNode.selectSingleNode("servlet-name").getStringValue();
            String servletUrl = servletNode.selectSingleNode("url-pattern").getStringValue();
            UrlservleNameMap.put(servletUrl,servletName );
        }

    }

    public static void main(String[] args) throws DocumentException {

    }

}
