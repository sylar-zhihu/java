package model.autoWire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * 作者:
 * 日期:2018年3月27日:下午4:25:47
 * 程序作用:使用spring生成对象
**/
public class TestAutoWire {

    @Test
    // 使用autoWired自动注入学生对象
    public void testAutoWare() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("AutoWiredBeans.xml");
        // 生成一个User对象 传入类ID
        Teacher teacher = (Teacher) factory.getBean("teacher");
        System.out.println(teacher.getStudent().getName());
        

    }

   

}
