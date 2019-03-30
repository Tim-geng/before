package com.baidu.service;

import com.baidu.util.Result;
import com.baidu.pojo.User;

import java.util.List;

public interface UserService {
    User login(User user);
    int add(User user);
    /*批量添加*/
    int batch(List<User> users);
    Result list(User user);
}
