package com.dao;

import com.vo.User;

public interface UserDao {
    public User login(User user);

    public User register(User user);
}
