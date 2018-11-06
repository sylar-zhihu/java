package model.component;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/*
 * 作者:
 * 日期:2018年3月27日:下午4:25:47
 * 程序作用:Bean工厂
**/
public class TestComponent {
    
    @Test
    // 得到注入的属性
    public void test属性注入() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ComponentBean.xml");
        // 得到对象
        Car  car= (Car) factory.getBean("car");
        System.out.println(car.getName());
        Student student=(Student) factory.getBean("student");
        System.out.println(student.getName());
    }


    
  

   

}
