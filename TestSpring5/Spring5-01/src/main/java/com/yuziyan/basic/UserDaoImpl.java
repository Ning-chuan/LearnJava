package com.yuziyan.basic;

public class UserDaoImpl implements UserDao{
    public void save(User user) {
        System.out.println("保存了用户："+user);
    }

    public void queryUserByNameAndPassword(String name, String password) {
        System.out.println("通过用户名："+name+"，和密码："+password+"查询了用户");
    }
}
