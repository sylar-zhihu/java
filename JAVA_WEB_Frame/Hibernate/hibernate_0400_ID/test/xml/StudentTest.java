package xml;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.StudentPK;
import com.bjsxt.hibernate.Teacher;

/*
 * 作者:
 * 日期:2018年5月14日:下午11:29:30
 * 程序作用:
**/
public class StudentTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

    @Test
    public void testStudentSave() {
        Student student=new Student();
        student.setAge(8);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

   

}
