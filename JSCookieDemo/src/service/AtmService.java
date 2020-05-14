package service;

public class AtmService {

    public String login(String uname,String upassword){
        if("于自言".equals(uname) && "666".equals(upassword)){
            return "登陆成功";
        }
        return "用户名或密码错误";
    }

}
