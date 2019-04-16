package com.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.vo.User;

import com.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{
	public User login(User user) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User existUser;
		try {
			existUser = queryRunner.query(sql,new BeanHandler<User>(User.class)
					,user.getUsername(),user.getPassword());
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("用户登录失败");
		}
		
		return existUser;
	}

	@Override
	public User register(User user) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql1 = "insert into user values(null,?,?,null)";
		String sql2 = "select * from user where username = ?";
		int num;
		try {
			
			System.out.println(user.getUsername()+" "+user.getPassword());
			User existUser = queryRunner.query(sql2,new BeanHandler<User>(User.class)
					,user.getUsername());
			//System.out.println(existUser.getUsername());
			System.out.println("1");
			if(existUser != null && user.getUsername().equals(existUser.getUsername())) {
				System.out.println("用户名已存在");
				user.setFlag(true);
				return user;
			}
			
			num = queryRunner.update(sql1,user.getUsername(),user.getPassword());
			System.out.println("2");
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("用户注册失败");
		}
		return user;
		
	}
}
