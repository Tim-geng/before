package com.baidu.service;

import org.apache.catalina.User;

public interface UserService {
    User login(User user);
    int add(User user);
}
