package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import advisorBefore.CustomerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:advisorBefore.xml")
public class Test_1_advisor {

    @Resource(name = "customerDao")
    // 非代理对象
    private CustomerDao customerDao;

    @Resource(name = "customerDaoProxy")
    // 代理增强对象
    private CustomerDao customerDaoAD;
    
    @Test
    // 不使用代理增强
    public void testNoAop() {
        customerDao.add();
        customerDao.update();
        customerDao.delete();
        customerDao.find();

    }

    @Test
    // 使用代理增强
    public void testAop() {
        customerDaoAD.add();
        customerDaoAD.update();
        customerDaoAD.delete();
        customerDaoAD.find();

    }

  
}
