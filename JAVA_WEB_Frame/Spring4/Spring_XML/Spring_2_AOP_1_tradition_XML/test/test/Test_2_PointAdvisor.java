package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pointcutAdvisor.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:pointcutAdvisorBeans.xml")
public class Test_2_PointAdvisor {

    @Resource(name = "orderDaoProxy")
    private OrderDao orderDao;

    @Test
    public void demo1() {
        orderDao.add();
        orderDao.delete();
        orderDao.update();
        orderDao.find();
    }

}
