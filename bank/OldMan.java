package bank;

public class OldMan extends Person {

    @Override
    public void callNum() {
        System.out.println("不会操作机器，只能叫保安帮助叫号，然后等待");
    }

    @Override
    public void transact() {
        System.out.println("打开手绢，小心翼翼的把要存的money交给工作人员");
    }

    @Override
    public void leave() {
        System.out.println("一步两步，一步两步的离开了");
    }
}
