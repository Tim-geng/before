package com.baidu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MyController {
    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }
}
