package com.yuziyan.seckill.controller;


import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser(int id) {
        return userService.getUser(id);
    }

}
