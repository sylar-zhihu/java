package model;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/*
 * 作者:
 * 日期:2018年4月22日:上午9:12:16
 * 程序作用:
**/
public class StudentSaveTest {

    @Test
    public void test() {
        // 新建对象
        Student student=new Student();
        student.setId("3");
        student.setName("aa");
        student.setAge(9);
        student.setBirthDay(new Date());
        // 得到配置对象
        Configuration configuration=new AnnotationConfiguration();
        // 获取配置文件 不指定文件，默认就找classpath根目录下的hibernate.cfg.xml
        configuration.configure("hibernate.cfg.xml");
        // 得到sesstion 数据库连接
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        // 所有的操作必须在事物中
        session.beginTransaction();
        session.save(student);
        // 提交事物
        session.getTransaction().commit();
        // 关闭
        session.close();
        sessionFactory.close();
        
        
    }

}
