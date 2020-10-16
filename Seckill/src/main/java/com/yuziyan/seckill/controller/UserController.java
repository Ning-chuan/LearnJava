package com.yuziyan.seckill.controller;


import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser(int id) {
        System.out.println("UserController.getUser");
        return userService.getUser(id);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user){
        System.out.println("UserController.login");
        System.out.println("user = " + user);
        if (user == null) {
            throw new RuntimeException("非法用户，请重新登录！");
        }
        Boolean res = userService.login(user);
        if (res) {
            return "itemList";
        }
        throw new RuntimeException("用户名或密码错误！");
    }



}
