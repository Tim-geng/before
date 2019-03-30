package com.baidu.controller;

import com.alibaba.fastjson.JSONObject;
import com.baidu.service.UserService;
import com.baidu.util.Message;
import com.baidu.util.MyUtil;
import com.baidu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public Message doLogin(User user,String code,HttpServletResponse response,HttpSession session){
        // 判断用户登录信息
        Message message = null;
        User login = userService.login(user);
        if(login == null)
            message = new Message(0, "用户名不存在");
        else{
            if(!login.getPassword().equals(user.getPassword())){
                message = new Message(0, "密码输入错误");
            }else{
                if(session.getAttribute("img")==null){
                    message = new Message(0, "登录超时");
                }else{
                    String img = session.getAttribute("img").toString();
                    if(!img.equalsIgnoreCase(code))
                        message = new Message(0, "验证码输入错误");
                    else
                        message = new Message(1, "登录成功");
                }
            }
        }
        return message;

    }
//    随机生成验证码图片
    @GetMapping("/img")
    public void getImg(HttpServletResponse response, HttpSession session) throws IOException {
        char[] arrray = MyUtil.getStr();//调用getStr生成随机四个数
        //设置图片底板大小
        BufferedImage image = new BufferedImage(100, 43, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
//        生成画笔
        graphics.setColor(Color.BLACK);
//        给底板图上颜色
        graphics.fillRect(0, 0, 100, 43);
//        生成第二只画笔
        graphics.setColor(Color.WHITE);
//        设置书写的样式
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 32));
//        设置书写的位置先把它转成字符串
        graphics.drawString(new String(arrray), 5, 30);
        session.setAttribute("img", new String(arrray));
//        传输(书写的图片,图片格式,往哪个输出流上传)
        ImageIO.write(image, "JPG", response.getOutputStream());
    }
}
