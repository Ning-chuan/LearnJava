package com.yuziyan.basic;

/**
 * dao层接口
 */
public interface UserDao {

    void save(User user);

    void queryUserByNameAndPassword(String name, String password);
}
