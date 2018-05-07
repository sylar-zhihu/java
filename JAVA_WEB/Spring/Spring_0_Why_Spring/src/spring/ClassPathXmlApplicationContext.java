package spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/*
 * 作者:
 * 日期:2018年3月27日:下午1:34:31
 * 程序作用: 模拟spring,通过ID得到生成的类对象。
**/

/**
 * @author asus
 *
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    
    // KEY :id VALUE:生成的对象
    private Map<String, Object> beans = new HashMap<String, Object>();

   
    /**
     * @throws 构造方法，记载xml文件，根据ID和class属性，生成对象
     */
    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder sb = new SAXBuilder();
        // 读取配置文件
        Document doc = sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
        Element root = doc.getRootElement();
        // 读取所有的bean
        List<Element> list =  root.getChildren("bean");
        // 根据id和class生成类对象, 放入beans Map中
        for (int i = 0; i < list.size(); i++) {
            Element element = list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            Object o = Class.forName(clazz).newInstance();
            System.out.println(id);
            System.out.println(clazz);
            beans.put(id, o);
            // 如果对象里面有，配置的property，根据set方法，去生成一个配置的对象类。
            for (Element propertyElement : (List<Element>) element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name"); // userDAO
                String bean = propertyElement.getAttributeValue("bean"); // u
                Object beanObject = beans.get(bean);// UserDAOImpl instance
                // 传入的property名前面加个set，然后第一个字母变成大写
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                System.out.println("method name = " + methodName);
                Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
                m.invoke(o, beanObject);
            }

        }

    }
    

    public Object getBean(String id) {
        return beans.get(id);
    }

}
