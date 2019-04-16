package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.vo.User;

public class UserService {
	public User login(User user) {
		UserDao userdao = new UserDaoImpl();
		return userdao.login(user);
	}
	
	public User register(User user) {
		UserDao userdao = new UserDaoImpl();
		return userdao.register(user);
	}
}
