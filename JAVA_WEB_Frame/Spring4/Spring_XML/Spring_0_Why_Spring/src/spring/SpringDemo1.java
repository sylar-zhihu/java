package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Spring的入门
 * 
 * @author jt
 *
 */
public class SpringDemo1 {

    @Test
    /**
     * 传统方式的调用UserDAOImpl
     */
    public void traditionUserDAOImpl() {
        UserDAO userDAO = new UserDAOImpl();
        userDAO.save();
    }
    
    @Test
    /**
     * 传统方式的调用UserDAOHibernateImpl
     * 需要修改源代码
     */
    public void traditionUserDAOHibernateImpl() {
        UserDAO userDAO = new UserDAOHibernateImpl();
        userDAO.save();
    }

    
    @Test
    /**
     * Spring的方式的调用,想用哪种实现，只用修改配置文件
     */
    public void demo2() {
        // 创建Spring的工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
        userDAO.save();
    }


}
