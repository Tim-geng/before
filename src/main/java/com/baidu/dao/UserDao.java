package com.baidu.dao;

import com.baidu.pojo.User;

import java.util.List;

public interface UserDao {
    User login(User user);
    int add(User user);
    /*批量添加*/
    int batch(List<User> users);
    List<User> list(User user);
    int count(User user);
}
