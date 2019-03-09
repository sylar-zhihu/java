package com.atguigu.spring.dataSource;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataSource {

	@Test
	public void test() throws Exception {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-datasource.xml");
		
		DataSource ds = ctx.getBean("dataSource",DataSource.class);
		
		System.out.println("ds:" + ds);
		
		System.out.println(ds.getConnection());
	}

}
