package service;

import org.junit.Test;

import model.User;

/*
 * 作者:
 * 日期:2018年3月27日:下午1:54:53
 * 程序作用:
**/
public class UserServiceTest {

    @Test
    // 把用户插入到数据库 不存在多个数据库
    public void testAdd() {
        UserService service = new UserService();
        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("zhangsan");
        service.add(u);
    }

}
