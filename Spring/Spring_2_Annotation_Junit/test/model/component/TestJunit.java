package model.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/*
 * 作者:
 * 日期:2018年3月27日:下午4:25:47
 * 程序作用:spring 整合Junit
**/
@RunWith(SpringJUnit4ClassRunner.class)// 固定写法
@ContextConfiguration(locations="classpath:ComponentBean.xml")// 指定spring的配置文件
public class TestJunit {
    
    @Autowired
    Student  student;
    
    @Autowired
    Teacher teacher;
    
    @Test
    // 直接注入
    public void test属性注入() {
        System.out.println(student.getName());
    }

    @Test
    // 直接注入
    public void testAutoWare() {
        System.out.println(teacher.getStudent().getName());
    }
    
  

   

}
