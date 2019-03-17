package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import advisorBefore.CustomerDao;
import pointcutAdvisor.OrderDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:auto.xml")
public class Test_3_Auto {

    @Autowired
    @Qualifier("orderDao")
    private OrderDao orderDao;

    @Autowired
    @Qualifier("customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo1() {
        orderDao.add();
        orderDao.delete();

        customerDao.update();
    }
}
