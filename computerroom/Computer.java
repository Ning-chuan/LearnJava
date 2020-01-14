package computerroom;

public class Computer {
//    1.模拟一个学生在机房内使用电脑的例子
//            有一个机房
//    有一台电脑	  电脑有开机/关机的状态  电脑被打开  被使用中  被关闭
//    有一个学生   使用电脑
//    让学生进入机房 使用电脑
//    扩展:  机房内放置5台电脑  让学生进入机房选择一台关闭的电脑使用
//    学生也有5个  陆续进入机房
    public int num;
    private String condition = "关闭";
    public Computer(){}
    public Computer(int num){
        this.num = num;
    }
    public void beTurnOn(){
        condition = "打开";
        System.out.println("此时电脑的状态为："+condition);
    }
    public void beTurnOff(){
        condition = "关闭";
        System.out.println("此时电脑的状态为："+condition);
    }
    public void beUsing(){
        condition = "打开";
        System.out.println("此时电脑的状态为："+condition);
    }
    public String getCondition(){
        return this.condition;
    }
}
