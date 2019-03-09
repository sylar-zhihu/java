package com.atguigu.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.spring.mvc.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired()   // 自动装配
	@Qualifier("userDaoJdbcImpl")
	private UserDao userDao ; 
	
	
	
	
//	@Autowired(required=false)   // 自动装配  byName  byType ?????
//	@Qualifier("userDaoJdbcImpl")
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	
	@Override
	public void handleAddUser() {
		//处理业务
		
		userDao.addUser();
	}
}
