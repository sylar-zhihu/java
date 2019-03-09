package com.atguigu.spring.mvc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.mvc.controller.UserController;
import com.atguigu.spring.mvc.dao.UserDao;
import com.atguigu.spring.mvc.service.UserService;

public class TestAnnotation {
	
	
	@Test
    // 得到注解的对象
	public void testGetAnnotationClass() {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-annotation.xml");
		UserController  uc =  ctx.getBean("userController",UserController.class);
		// 得到对象 调用方法
        uc.say();
		
		UserService us = ctx.getBean("userServiceImpl",UserService.class);
		System.out.println("userService:" + us);

		UserDao  ud = ctx.getBean("userDaoJdbcImpl",UserDao.class);
		System.out.println("userDao: " + ud );
		
		uc.regist();
		
	}
}
