package com.yuziyan.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//相当于 @Controller + @ResponseBody
public class HelloWorld {

    @RequestMapping("hello")
    public String hello(){
        return "Hello SpringBoot";
    }
}
