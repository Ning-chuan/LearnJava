package service;

import dao.ATMdao;
import domain.User;

public class Service {
    private ATMdao dao = new ATMdao();


    //登录
    public String login(String name,String password){
        User user = dao.selectOne(name);
        if(user!=null && user.getPassword().equals(password)){
            return "登陆成功";
        }
        return "用户名或密码错误";
    }
    //查询余额
    public Float checkBalance(String name){
        return dao.selectOne(name).getBalance();
    }

    //存款
    public boolean depositMoney(String name,float money){
        User user = dao.selectOne(name);
        user.setBalance(user.getBalance() + money);
        return dao.update(user);
    }

    //取款
    public boolean withdrawMoney(String name,float money){
        User user = dao.selectOne(name);
        if(user.getBalance()>=money){
            user.setBalance(user.getBalance()-money);
        }else{
            System.out.println("您的余额不足。");
            return false;
        }
        return dao.update(user);
    }

    //转账
    public void transferMoney(String outName,String inName,Float money){
        User outUser = dao.selectOne(outName);
        User inUser = dao.selectOne(inName);
        if(outUser.getBalance()>=money){
            outUser.setBalance(outUser.getBalance()-money);
            inUser.setBalance(inUser.getBalance()+money);
            dao.update(outUser);
            dao.update(inUser);
            System.out.println("转账成功。");
        }else{
            System.out.println("您的余额不足。");
        }
    }


    //开户
    public void openAnAccount(String name,String password,float balance){
        User user = new User(name,password,balance);
        boolean result = dao.insert(user);
        if(result){
            System.out.println("开户成功！");
        }
    }

    //销户
    public void closeAnAccount(String name){
        boolean result = dao.delete(name);
        if(result){
            System.out.println("销户成功！");
        }
    }



}
