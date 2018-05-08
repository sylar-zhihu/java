package 动态代理.CGlib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用CGLib生成代理对象
 * 
 * @author 168
 *
 */
// 实现MethodInterceptor 需要实现intercept 方法
public class CGLibProxy implements MethodInterceptor {
    // 需要加强的对象
    private ProductDao productDao;

    public CGLibProxy(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    // 生成代理对象
    public ProductDao createProxy() {
        // 使用CGLIB生成代理:
        // 1.创建核心类:
        Enhancer enhancer = new Enhancer();
        // 2.因为是继承，所以要为其设置父类:
        enhancer.setSuperclass(productDao.getClass());
        // 3.设置回调:
        enhancer.setCallback(this);
        // 4.创建代理:
        return (ProductDao) enhancer.create();
    }

    @Override
    // 这个就是加强的方法
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // 根据函数名判断
        if ("add".equals(method.getName())) {
            // 加入自己的代码
            System.out.println("日志记录==============");
            // 调用原来的方法
            Object obj = methodProxy.invokeSuper(proxy, args);
            return obj;
        }
        return methodProxy.invokeSuper(proxy, args);
    }
}
