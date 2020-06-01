package com.dao;

import com.vo.User;

public interface UserDao {
    User login(User user);

    User register(User user);

    User edit(User user);

    User getUser(int id);
}
