package service;

import dao.UserDao;
import domain.User;
import util.MySpring;

public class ShoppingService {

    UserDao userDao = MySpring.getBean("dao.UserDao");

    public String login(String uname,String upassword){
        String result = "用户名或密码错误";
        User user = userDao.selectOne(uname);
        if(user!=null && upassword.equals(user.getUpassword())){
            result = "登陆成功";
        }
        return result;
    }
}
