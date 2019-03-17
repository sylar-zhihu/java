package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import scope.Prototype;
import scope.SingletonScope;

public class Test_3_Scope {

    @Test
    /**
     * 测试单例：默认就是单例
     */
    public void testSingleton() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("scope.xml");
        SingletonScope singletonScope1 = (SingletonScope) applicationContext.getBean("singletonScope");
        System.out.println(singletonScope1);
        SingletonScope singletonScope2 = (SingletonScope) applicationContext.getBean("singletonScope");
        System.out.println(singletonScope2);
        // 判断是否相等 true 单利是相等的
        System.out.println(singletonScope1 == singletonScope2);
    }
    
    @Test
    /**
     * 测试多例
     */
    public void testPrototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("scope.xml");
        Prototype prototype1 = (Prototype) applicationContext.getBean("prototype");
        System.out.println(prototype1);
        Prototype prototype2 = (Prototype) applicationContext.getBean("prototype");
        System.out.println(prototype2);
        // 判断是否相等 flase  多利是不相等的
        System.out.println(prototype1 == prototype2);
    }
    
    
    

}
