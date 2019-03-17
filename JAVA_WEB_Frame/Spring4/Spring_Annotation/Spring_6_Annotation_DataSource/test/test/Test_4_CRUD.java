package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.User;
import model.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-crud.xml")
public class Test_4_CRUD {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    
    @Test
    public void demo_1_createTable() {
        userDao.create("user");
    }
    

    @Test
    public void demo_2_save() {
        User user = new User();
        user.setName("小胖");
        userDao.add(user);
    }

    @Test
    public void demo_3_update() {
        User user = new User();
        user.setId(1);
        user.setName("小边");
        userDao.update(user);
    }

    @Test
    public void demo_3_delete() {
        User user = new User();
        user.setId(1);
        userDao.delete(user);
    }

    @Test
    public void demo4_Count() {
        int count = userDao.findCount();
        System.out.println(count);
    }

    @Test
    public void demo5_select() {
        String name = userDao.findNameById(2);
        System.out.println(name);
    }

    @Test
    public void demo6_select2() {
        User user = userDao.findById(2);
        System.out.println(user);
    }

    @Test
    public void demo7_findAll() {
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
