package com.atguigu.spring.helloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 获取到Person对象.

        // 1. 创建Spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 方法1
        // Person person = (Person)ctx.getBean("person");


        // 根据id来拿
        Person person = ctx.getBean("person", Person.class);
        // 3. 调用方法
        person.sayHello();
        
        Person person2 = ctx.getBean("person1", Person.class);
        // 3. 调用方法
        person2.sayHello();
        
        
    }
}
