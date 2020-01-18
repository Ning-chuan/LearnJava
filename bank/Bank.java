package bank;

public  class Bank {
    public void welcomeClient(Person p){
        System.out.println("欢迎您来我行办理业务");
        p.callNum();
        p.transact();
        p.leave();
    }
}
