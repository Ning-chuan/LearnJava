package service;

import dao.AtmDao;
import domain.User;
import spring.MySpring;

//业务层 做逻辑判断
public class AtmService {

    //应当有一个AtmDao对象  我们自己创建一个MySpring类来托管对象
    AtmDao dao = MySpring.getBean("dao.AtmDao");

    public String login(String aname,String apassword){
        String result = "登陆失败";
        User user = dao.selectOne(aname);
        if(user != null){
            if(apassword.equals(user.getApassword())){
                result = "登陆成功";
            }
        }
        return result;
    }
}
