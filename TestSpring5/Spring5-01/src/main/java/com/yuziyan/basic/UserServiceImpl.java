package com.yuziyan.basic;

/**
 * 业务层实现类
 */
public class UserServiceImpl implements UserService{

    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //======================业务方法=========================
    public void register(User user) {
        userDao.save(user);
    }

    public void login(String name, String password) {
        userDao.queryUserByNameAndPassword(name,password);
    }
}
