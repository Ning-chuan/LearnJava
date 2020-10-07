package com.yuziyan.factory;

import com.yuziyan.proxy.User;

public interface UserService {

    void register(User user);

    boolean login(String name,String password);
}
