package spring;

import org.junit.Test;

import model.User;
import service.UserService;

/*
 * 作者:
 * 日期:2018年3月27日:下午2:52:37
 * 程序作用: 模拟spring的源码
**/
public class ClassPathXmlApplicationContextTest {

    @Test
    public void test() throws Exception {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext();

        UserService service = (UserService) applicationContext.getBean("userService");
        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("zhangsan");
        service.add(u);
    }

}
