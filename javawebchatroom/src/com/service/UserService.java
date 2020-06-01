package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.vo.User;

public class UserService {
    private UserDao userdao = new UserDaoImpl();

    public User login(User user) {
        return userdao.login(user);
    }

    public User register(User user) {
        return userdao.register(user);
    }

    public User edit(User user) {
        return userdao.edit(user);
    }

}
