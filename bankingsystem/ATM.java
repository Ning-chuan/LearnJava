package bankingsystem;

public class ATM {
    //注册 开户
    public void register(String name,int password,int balances){
        new User(name,password,balances);
    }
}
