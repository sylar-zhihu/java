package annotation;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.StudentPK;

import xml.Student;

/*
 * 作者:
 * 日期:2018年5月14日:下午11:17:34
 * 程序作用:
**/
public class TeacherTest {
   

    @Test
    public void testTeacherSave() {
        Teacher teacher=new Teacher();
        teacher.setName("ljb");       

        Session session = new AnnotationConfiguration().configure().buildSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        
    }


}
