package bankingsystem;

import java.io.*;

public class ATM {
    //注册 开户
    public void register(String name,int password,int balances){
        User user = new User(name,password,balances);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("D:/test/银行用户信息.txt",true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
            System.out.println("注册成功");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //登录
    public String login(String name,int password){
        User user = this.getUser(name);
        if(user!=null) {
            if (user.getPassword() == password) {
                return "登陆成功";
            }
        }
        return "用户名或密码错误";
    }

    //余额查询
    public int balanceInquiry(String name){
        return this.getUser(name).getBalances();
    }

    //存款 取款
    public int deposit(String name,int money){//返回余额
        User user = this.getUser(name);
        user.balances = user.balances+money;
        return user.balances;
    }
    public int withdrawal(String name,int money){//返回余额
        User user = this.getUser(name);
        if(user.balances>=money){
            user.balances = user.balances-money;
            return user.balances;
        }else{
            user.balances = 0;
            return 0;
        }
    }

    //转账
    public boolean transfer(String name,String aimName,int money){
        User user = this.getUser(name);
        User aimUser = this.getUser(aimName);
        if(user!=null && aimUser!=null) {
            user.balances = user.balances - money;
            aimUser.balances = aimUser.balances + money;
            return true;
        }
        return false;
    }

    //注销账户


    //获取User对象
    private User getUser(String name){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("D:/test/银行用户信息.txt");
            ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            while (user != null) {
                if (user.getName().equals(name)) {
                    return user;
                }
                user = (User) ois.readObject();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
