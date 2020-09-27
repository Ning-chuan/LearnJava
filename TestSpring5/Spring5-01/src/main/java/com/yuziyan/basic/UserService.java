package com.yuziyan.basic;

/**
 * 业务层接口：定义有哪些业务
 */
public interface UserService {

    //注册用户
    void register(User user);

    //登录
    void login(String name,String password);

}
