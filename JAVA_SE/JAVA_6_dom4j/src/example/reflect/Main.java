package example.reflect;

import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import example.reflect.HelloServlet;;

/*
 * 作者:Lijianbo
 * 日期:2016年6月27日:下午3:09:32
 * 程序作用:使用DOM4J解析myweb.xml,通过反射HelloServlet中的run方法执行
 * 模拟struts2
**/

public class Main {

    @Test
    public void run() throws Exception {
        // 解析myweb.xml
        // 获取解析器
        SAXReader reader = new SAXReader();
        // 解析
        Document document = reader.read("src/demo/reflect/myweb.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取servlet节点
        Element servlet = root.element("servlet");
        Element servletClass = servlet.element("servlet-class");
        // 获取包名+类名的全路径
        String path = servletClass.getText();

        // 反射获取Class
        Class reflectClass = Class.forName(path);
        // 获取实例 同时转成对象
        HelloServlet hello = (HelloServlet) reflectClass.newInstance();
        // 获取方法
        Method method = reflectClass.getDeclaredMethod("run");
        // 方法可见
        method.setAccessible(true);
        // 通过类调用方法
        method.invoke(hello);
    }

}
