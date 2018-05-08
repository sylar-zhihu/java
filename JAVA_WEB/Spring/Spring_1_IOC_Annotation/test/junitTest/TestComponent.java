package junitTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.component.Student;
import model.component.Teacher;

/*
 * 作者:
 * 日期:2018年3月27日:下午4:25:47
 * 程序作用:使用spring生成对象
**/
// 必须写
@RunWith(SpringJUnit4ClassRunner.class)
// 指定创建容器时使用哪个配置文件
@ContextConfiguration("classpath:ComponentBean.xml")
public class TestComponent {
    // 将名为student的对象注入到student变量中
    @Resource(name = "student")
    Student student;

    @Resource(name = "teacher")
    Teacher teacher;

    @Test
    // 测试spring整合junit
    public void test属性注入() {
        // 生成一个User对象 传入类ID
        System.out.println(student.getName());

    }

    @Test
    // 测试spring整合junit
    public void testAutoWare() {
        System.out.println(teacher.getStudent().getName());

    }

}
