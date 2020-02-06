package bankingsystem;

import java.io.*;
import java.util.HashMap;

public class ATMService {
    private ATMDao atmDao = new ATMDao();
    //注册 开户
    public void register(String name,int password,int balances){
        User user = new User(name,password,balances);
        atmDao.update(user);
    }

    //登录
    public String login(String name,int password){
        User user = atmDao.selectUser(name);
        if(user!=null) {
            if (user.getPassword()==password) {
                return "登陆成功";
            }
        }
        return "用户名或密码错误";
    }

    //余额查询
    public int balanceInquiry(String name){
        return atmDao.selectUser(name).getBalances();
    }


    //存款 取款
    public void deposit(String name,int money){
        User user = atmDao.selectUser(name);
        user.setBalances(user.getBalances()+money);
    }
    public void withdrawal(String name,int money){
        User user = atmDao.selectUser(name);
        if(user.getBalances()>=money){
            user.setBalances(user.getBalances()-money);
        }else{
            System.out.println("您的余额不足");
        }
    }


    //转账
    public String transfer(String name,String aimName,int money){
        User user = atmDao.selectUser(name);
        User aimUser = atmDao.selectUser(aimName);
        if(aimUser!=null) {
            if(user.getBalances()>=money){
                user.setBalances(user.getBalances()-money);
                aimUser.setBalances(aimUser.getBalances()+money);
                return "转账成功";
            }else{
                return "您的余额不足";
            }
        }else{
            return "该用户不存在";
        }
    }

    //注销账户
    public void logout(String name){
        atmDao.closeAccount(name);
    }
}
