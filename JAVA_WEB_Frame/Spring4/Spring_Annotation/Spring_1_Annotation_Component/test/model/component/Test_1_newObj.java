package model.component;

import javax.annotation.Resource;

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
 * 程序作用:使用spring生成对象
**/


public class Test_1_newObj {
    
    
    // @Component 注入对象 @Value("sylar")  得到注入的属性
    @Test
    public void testComponent() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ComponentBean.xml");
        // 生成一个student对象  得到注入的属性
        Student  student= (Student) factory.getBean("student");
        System.out.println(student.getName());
    }

    @Test
    // @Autowired注入对象 得到注入的对象 
    public void testAutoWare() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ComponentBean.xml");
        // 生成一个User对象 传入类ID
        TeacherAuto teacherAuto = (TeacherAuto) factory.getBean("teacherAuto");
        System.out.println(teacherAuto.getStudent().getName());
        

    }
    
    @Test
    // @Resource(name = "student")注入对象 得到注入的对象 
    public void testResource() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ComponentBean.xml");
        // 生成一个User对象 传入类ID
        TeacherResource teacherResource = (TeacherResource) factory.getBean("teacherResource");
        System.out.println(teacherResource.getStudent().getName());
        

    }
    
  

   

}
