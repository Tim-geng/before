package com.baidu.service;

import com.baidu.dao.UserDao;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }
}
