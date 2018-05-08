package 动态代理.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理的机制
 * 
 * @author 168
 * 
 */
// 实现InvocationHandler
public class JDKProxy implements InvocationHandler {
    // 被代理对象
    private UserDao userDao;

    // 通过构造函数传入
    public JDKProxy(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    // 返回代理对象
    public UserDao createProxy() {
        // 三个参数 类加载器，实现的接口， InvocationHandler类实现了这个接口 传进去就行
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);
        return proxy;
    }

    // 调用目标对象的任何一个方法 都相当于调用invoke();
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断方法名
        if ("add".equals(method.getName())) {
            // 记录日志:
            System.out.println("日志记录=================");
            // 调用本来的类的方法
            Object result = method.invoke(userDao, args);
            return result;
        }
        return method.invoke(userDao, args);
    }
}
