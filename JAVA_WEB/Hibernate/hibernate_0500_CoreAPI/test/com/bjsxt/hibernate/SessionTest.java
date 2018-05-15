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

public class SessionTest {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

    /**
     * 作者：
     * 用途说明：getCurrentSession 如果不commit 就永远是同一个session 不用close
     */
    @Test
    public void testGetCurrentSession() {
        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.save(t);

        Session session2 = sessionFactory.getCurrentSession();
        // true 没有提交是同一个session
        System.out.println(session == session2);

        session.getTransaction().commit();

        Session session3 = sessionFactory.getCurrentSession();
        // false 提交后 得到一个新的session
        System.out.println(session == session3);

    }

    @Test
    // openSession 永远是新的session 需要close
    public void testOpenSession() {
        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(t);

        Session session2 = sessionFactory.getCurrentSession();
        // false 
        System.out.println(session == session2);

        session.getTransaction().commit();

        Session session3 = sessionFactory.getCurrentSession();
        // false 
        System.out.println(session == session3);

    }
}
