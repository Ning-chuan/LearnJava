package service;

import dao.AtmDao;
import domain.User;

public class AtmService {

    private AtmDao atmDao = new AtmDao();


    //登录方法
    public String login(String aname,String apassword){
        User user = atmDao.selectOne(aname);
        if(user!=null && user.getApassword().equals(apassword)){
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    //查询余额方法
    public Float inquireBalance(String aname){
        return atmDao.selectOne(aname).getAbalance();
    }

    //取款方法
    public int withdrawalMoney(String aname,Float withdrawalMoney){
        User user = atmDao.selectOne(aname);
        if(user.getAbalance()>=withdrawalMoney){
            user.setAbalance(user.getAbalance()-withdrawalMoney);
            return atmDao.update(user);
        }else{
            return -1;//表示余额不足
        }

    }

    //存款方法
    public int depositMoney(String aname,Float depositMoney){
        User user = atmDao.selectOne(aname);
        user.setAbalance(user.getAbalance()+depositMoney);
        return atmDao.update(user);
    }

    //转账方法
    public int transferMoney(String outName,String inName,Float transferMoney){
        User outUser = atmDao.selectOne(outName);
        User inUser = atmDao.selectOne(inName);
        if(outUser.getAbalance()>=transferMoney){
            outUser.setAbalance(outUser.getAbalance()-transferMoney);
            inUser.setAbalance(inUser.getAbalance()+transferMoney);
            return atmDao.update(outUser)+atmDao.update(inUser);
        }
        return -1;
    }

    //注册新用户
    public int register(String aname,String apassword,Float abalance){
        return atmDao.insert(new User(aname,apassword,abalance));
    }

    //销户
    public int logout(String aname){
        return atmDao.delete(aname);
    }

    //判断是否存在
    public boolean isExist(String aname){
        if(atmDao.selectOne(aname)!=null){
            return true;
        }else{
            return false;
        }
    }
}
