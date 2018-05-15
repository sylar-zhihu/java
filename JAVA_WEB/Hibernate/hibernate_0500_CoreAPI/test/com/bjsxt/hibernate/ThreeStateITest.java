package com.bjsxt.hibernate;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThreeStateITest {
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
    public void testSaveWith3State() {
     // Transient 
        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());
        
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        // Persistent
        System.out.println(t.getId());// 1
        session.getTransaction().commit();// 
        // Detached
        System.out.println(t.getId());//1
    }
}
