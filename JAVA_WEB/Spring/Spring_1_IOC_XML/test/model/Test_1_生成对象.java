package model;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Student;

/*
 * 作者:
 * 日期:2018年3月27日:下午4:25:47
 * 程序作用:使用spring生成对象
**/
public class Test_1_生成对象 {
    
    public static String beansName="beans1.xml";

    @Test
    // 生成一个Student对象 无参数
    public void testStudent() {
        // 生成工厂对象
        ApplicationContext factory = new ClassPathXmlApplicationContext(beansName);
        // 生成一个User对象 传入类ID
        Student student = (Student) factory.getBean("student");
        System.out.println("生成一个无参的学生对象");
        System.out.println("学生的名字为： " + student.getName());

    }

    @Test
    // 给生产对象添加参数 给Student加一个名字
    public void testStudentPara() {
        // 生成工厂对象
        ApplicationContext factory = new ClassPathXmlApplicationContext(beansName);
        // 生成一个User对象 传入类ID
        Student student = (Student) factory.getBean("student1");
        System.out.println("生成一个有参数的学生对象");
        System.out.println("学生的名字为： " + student.getName());

    }

    @Test
    // 生成一个老师对象
    public void testTeacher() {
        // 生成工厂对象
        ApplicationContext factory = new ClassPathXmlApplicationContext(beansName);
        // 生成一个User对象 传入类ID
        Teacher teacher = (Teacher) factory.getBean("teacher");
        System.out.println("生成一个有参数的老师");
        System.out.println("老师的名字为： " + teacher.getName());
        System.out.println("老师的第一个学生名字为： " + teacher.getMyStudents().get(0).getName());
        System.out.println("老师的第二个学生名字为： " + teacher.getMyStudents().get(1).getName());

    }

}
