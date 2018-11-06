package model.component;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/*
 * 作者:
 * 日期:2018年3月27日:下午4:25:47
 * 程序作用:使用spring生成对象
**/
public class TestComponent {
    
    @Test
    // 得到注入的属性
    public void test属性注入() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ComponentBean.xml");
        // 生成一个student对象  得到注入的属性
        Student  student= (Student) factory.getBean("student");
        System.out.println(student.getName());
    }

    @Test
    // 得到注入的对象
    public void testAutoWare() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ComponentBean.xml");
        // 生成一个User对象 传入类ID
        Teacher teacher = (Teacher) factory.getBean("teacher");
        System.out.println(teacher.getStudent().getName());
        

    }
    
  

   

}
