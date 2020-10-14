package com.yuziyan.seckill.service.impl;

import com.yuziyan.seckill.dao.UserDao;
import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User getUser(int id) {
        return userDao.getUser(id);
    }

}
