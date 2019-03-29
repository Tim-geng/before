package com.baidu.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baidu.util.Page;

import java.util.Date;

public class User extends Page {
    private Integer id;
    private String loginId;
    private String name;
    private String phone;
    private String password;
    private Integer sex;
    @JSONField(format = "yyyy/MM/dd")
    private Date birthday;
    private String email;
    private String address;
    private Integer isDel;

    public User(Integer code, Object message) {
        super(code, message);
    }
}
