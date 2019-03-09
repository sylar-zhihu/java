package com.atguigu.spring.annotation.Component.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {

    @Test
    // 单例注解测试
    public void testSingleton() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-annotation.xml");

        // 生成两个单利对象
        ScopePersonSingleton person = ctx.getBean("scopePersonSingleton", ScopePersonSingleton.class);
        ScopePersonSingleton person2 = ctx.getBean("scopePersonSingleton", ScopePersonSingleton.class);
        // true
        System.out.println(person==person2);
    }

    @Test
    // 多例注解测试
    public void testPrototype() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-annotation.xml");

        // 生成两个单利对象
        ScopePersonPrototype person = ctx.getBean("scopePersonPrototype", ScopePersonPrototype.class);
        ScopePersonPrototype person2 = ctx.getBean("scopePersonPrototype", ScopePersonPrototype.class);
        // false
        System.out.println(person==person2);
    }


}
