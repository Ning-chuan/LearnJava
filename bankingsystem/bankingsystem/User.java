package bankingsystem;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5581975624957396927L;
    private String name;
    private int password;
    int balances;


    //获取User相关信息的方法
    public User(String name, int password, int balances){
        this.name = name;
        this.password = password;
        this.balances = balances;
    }

    public String getName(){
        return this.name;
    }
    public int getPassword(){
        return this.password;
    }
    public int getBalances(){
        return this.balances;
    }



    //重写equals()
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o instanceof User){
            User anotherUser = (User)o;
            if(this.name.equals(anotherUser.name)){
                return true;
            }
        }
        return false;
    }
    //重写hashCode()
    public int hashCode(){
        return this.name.hashCode();
    }
}
