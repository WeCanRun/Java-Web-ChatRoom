package com.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.vo.User;

import com.utils.JDBCUtils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    public User login(User user) {
        String sql = "select * from user where username = ? and password = ?";
        User existUser;
        try {
            existUser = queryRunner.query(sql, new BeanHandler<User>(User.class)
                    , user.getUsername(), user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户登录失败");
        }

        return existUser;
    }

    @Override
    public User register(User user) {
        String sql1 = "insert into user values(null,?,?,null,null,null)";
        String sql2 = "select * from user where username = ?";
        try {

            System.out.println(user.getUsername() + " " + user.getPassword());
            User existUser = queryRunner.query(sql2, new BeanHandler<User>(User.class)
                    , user.getUsername());

            if (existUser != null && user.getUsername().equals(existUser.getUsername())) {
                System.out.println("用户名已存在");
                user.setFlag(true);
                return user;
            }

            queryRunner.update(sql1, user.getUsername(), user.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户注册失败");
        }
        return user;

    }

    @Override
    public User edit(User user) {
        User newUser;
        try {
            String sql = "select * from user where username = ?";
            User existUser = queryRunner.query(sql, new BeanHandler<User>(User.class)
                    , user.getUsername());

            if (existUser != null && user.getUsername().equals(existUser.getUsername())) {
                System.out.println("用户名已存在");
                user.setFlag(true);
                return user;
            }
            sql = "update user set username = ?, phone = ?, adress = ? where id = ?";

            System.out.println(user);
            int rows = queryRunner.update(sql, user.getUsername(), user.getPhone(), user.getAdress(), user.getId());
            if (rows <= 0) {
                throw new RuntimeException("更新用户信息失败");
            }

            sql = "select * from user where id = ?";
            newUser = queryRunner.query(sql, new BeanHandler<User>(User.class)
                    , user.getId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("编辑用户信息失败");
        }

        return newUser;
    }

    @Override
    public User getUser(int id) {
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
