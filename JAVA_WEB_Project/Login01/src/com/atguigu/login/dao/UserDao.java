package com.atguigu.login.dao;

import com.atguigu.login.beans.User;

public interface UserDao {

	public User getUserByUsernameAndPassword(String username,String password);
}
