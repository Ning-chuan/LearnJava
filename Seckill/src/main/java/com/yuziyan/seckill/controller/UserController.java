package com.yuziyan.seckill.controller;


import com.yuziyan.seckill.entity.SeckillItem;
import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.exception.UserException;
import com.yuziyan.seckill.service.SeckillItemService;
import com.yuziyan.seckill.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    SeckillItemService seckillItemService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser(int id) {
        System.out.println("UserController.getUser");
        return userService.getUser(id);
    }

    @RequestMapping(value = "/login")
    public String login(String username, String password, Model model) {
        //数据校验
        if (username == null || "".equals(username) && password == null || "".equals(password)) {
            throw new UserException("非法登用户，请重新录！");
        }
        //调用业务层登录方法
        Boolean res = userService.login(username, password);
        if (!res) {
            throw new UserException("用户名或密码错误");
        }
        //用户名密码正确，调用业务层查询商品列表，并返回
        List<SeckillItem> seckillItemList = seckillItemService.getSeckillItemList();
        model.addAttribute("seckillItemList", seckillItemList);
        return "itemList";
    }


}
