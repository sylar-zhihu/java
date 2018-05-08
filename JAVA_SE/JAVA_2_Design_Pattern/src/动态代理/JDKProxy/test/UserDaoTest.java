package 动态代理.JDKProxy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import 动态代理.JDKProxy.JDKProxy;
import 动态代理.JDKProxy.UserDao;
import 动态代理.JDKProxy.UserDaoImpl;

/*
 * 作者:168
 * 日期:2018年5月8日:上午11:32:52
 * 程序作用:测试生成的动态代理
**/
public class UserDaoTest {

    @Test
    public void 传统调用() {
        UserDao userDao = new UserDaoImpl();
        userDao.add();
        userDao.update();
    }

    @Test
    public void 动态代理调用() {
        // 被代理对象
        UserDao userDao = new UserDaoImpl();
        // 创建代理对象的时候传入被代理对象.
        UserDao proxy = new JDKProxy(userDao).createProxy();
        proxy.add();
        proxy.update();
    }

}
