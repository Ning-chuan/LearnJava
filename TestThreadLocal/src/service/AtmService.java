package service;

import domain.User;
import util.ThreadLocalManager;

public class AtmService {

    public String login(String uname,String upassword){
        if("宋江".equals(uname) && "333".equals(upassword)){
            //把User对象装进ThreadLocal里 可以使上面的层次访问到
            User user = new User("宋江","333","及时雨");
            ThreadLocal local = ThreadLocalManager.getThreadLocal(uname);
            local.set(user);
            return "登陆成功";
        }
        return "用户名或密码错误";
    }

}
