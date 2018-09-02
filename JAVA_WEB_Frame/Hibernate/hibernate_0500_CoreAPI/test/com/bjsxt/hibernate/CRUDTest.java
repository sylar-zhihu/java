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

public class CRUDTest {
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
    // save
    public void testSave() {
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

    @Test
    // 有了id就可以删除 根据主键删除
    public void testDelete() {

        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(t);
        System.out.println(t.getId());// 1
        session.getTransaction().commit();

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        System.out.println(t.getId());// 1
        session2.delete(t);
        session2.getTransaction().commit();
    }

    @Test
    // 如果id不存在 会报错
    public void testDelete2() {

        Teacher t = new Teacher();
        t.setId(1);
        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.delete(t);
        session2.getTransaction().commit();
    }

    @Test
    // 延迟加载 不会真正执行，直到取出属性的时候才会执行 返回的是代理对象
    public void testLoad() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // 类的class 和主键
        Teacher t = (Teacher) session.load(Teacher.class, 1);

        session.getTransaction().commit();
        // 是代理对象
        System.out.println(t.getClass());
        // session关闭后会报错
        System.out.println(t.getName());
    }

    @Test
    // 直接取出对象 找不到对象 会报错
    public void testGet() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        // 类的class 和主键
        Teacher t = (Teacher) session.get(Teacher.class, 1);

        session.getTransaction().commit();
        System.out.println(t.getClass());
        // System.out.println(t.getName());
    }

    @Test
    //Detached 可以更新
    public void testUpdateDetached() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.get(Teacher.class, 1);
        session.getTransaction().commit();
        t.setName("zhanglaoshi");
        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.update(t);

        session2.getTransaction().commit();
    }

    @Test
    // Transient不能更新  会报错
    public void testUpdateTransientError () {

        Teacher t = new Teacher();
        t.setName("zhanglaoshi");

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.update(t);

        session2.getTransaction().commit();
    }

    @Test
    // Transient 自己设置id可以更新  没啥意义
    public void testUpdate3() {

        Teacher t = new Teacher();
        t.setId(1);
        t.setName("zhanglaoshi");

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.update(t);

        session2.getTransaction().commit();
    }

    @Test
    // Persistent 可以更新 
    public void testUpdatePersistent() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.get(Teacher.class, 1);
        t.setName("zhangsan2");
        session.getTransaction().commit();
    }

    @Test
    public void testUpdate5() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class, 1);
        s.setName("zhangsan5");
        session.getTransaction().commit();

        s.setName("z4");

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.update(s);
        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate6() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class, 1);
        s.setName("zhangsan6");
        session.getTransaction().commit();

        s.setName("z4");

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.merge(s);
        session2.getTransaction().commit();
    }

    @Test
    public void testUpdate7() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("update Student s set s.name='z5' where s.id = 1");
        q.executeUpdate();
        session.getTransaction().commit();

    }

    @Test
    public void testSaveOrUpdate() {

        Teacher t = new Teacher();
        t.setName("t1");
        t.setTitle("middle");
        t.setBirthDate(new Date());

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(t);

        session.getTransaction().commit();

        t.setName("t2");

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        session2.saveOrUpdate(t);
        session2.getTransaction().commit();

    }

    @Test
    public void testClear() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.load(Teacher.class, 1);
        System.out.println(t.getName());

        session.clear();

        Teacher t2 = (Teacher) session.load(Teacher.class, 1);
        System.out.println(t2.getName());
        session.getTransaction().commit();

    }

    @Test
    public void testFlush() {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Teacher t = (Teacher) session.load(Teacher.class, 1);
        t.setName("tttt");

        session.clear();

        t.setName("ttttt");

        session.getTransaction().commit();

    }

    @Test
    public void testSchemaExport() {
        // @param script print the DDL to the console 打印建表语句
        // @param export export the script to the database 执行建表语句
        new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
    }

    public static void main(String[] args) {
        beforeClass();
    }
}
