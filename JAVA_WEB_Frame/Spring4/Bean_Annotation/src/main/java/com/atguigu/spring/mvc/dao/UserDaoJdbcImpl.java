package com.atguigu.spring.mvc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJdbcImpl  implements UserDao{

	
	@Override
	public void addUser() {
		System.out.println("UserDao  Jdbc .....");
	}
}
