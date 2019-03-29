package com.baidu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.service.UserService;
import com.baidu.util.Page;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class MyController {
    @Resource
    UserService userService;
    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public String doLogin(User user){
        //判断用户登录信息
        Page message = null;
        User login = userService.login(user);
        if (login == null){
            message = new Page(0,"用户名不存在");
        }else {
            if (login.getPassword().equals(user.getPassword())){
                message = new Page(0,"密码错误");
            }else {
                message = new Page(1,"登录成功");
            }
        }
//        把对象转换成json-----fastjson,tojsonstring
            return JSONObject.toJSONString(message);

    }

}
