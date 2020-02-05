package bankingsystem;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int password;
    private int balances;
    public User(String name, int password, int balances){
        this.name = name;
        this.password = password;
        this.balances = balances;
    }
    public String getName(){
        return this.name;
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
