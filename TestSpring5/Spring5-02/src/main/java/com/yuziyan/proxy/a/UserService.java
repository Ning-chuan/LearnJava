package com.yuziyan.proxy.a;

import com.yuziyan.proxy.User;

public interface UserService {
    public void register(User user);

    public boolean login(String name, String password);
}
