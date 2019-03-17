package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lifeCycle.CustomerDAO;

public class Test_2_LifeCycle {

    @Test
    /**
     * 生命周期的配置
     */
    public void testInit() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lifeCycle.xml");
        CustomerDAO customerDAO = (CustomerDAO) applicationContext.getBean("customerDAO");
        customerDAO.save();
    }

    @Test
    /**
     * 生命周期的配置
     */
    public void testInitAndDestory() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("lifeCycle.xml");
        CustomerDAO customerDAO = (CustomerDAO) applicationContext.getBean("customerDAO");
        customerDAO.save();
        // 调用了关闭工程，构造的对象也就销毁了
        applicationContext.close();
    }

}
