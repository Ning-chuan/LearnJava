package computerroom;

public class Student {
    private String name;
    //为了使程序好玩，给每个同学随机一个数字 0~4代表使用完之后会关电脑，5~9表示不会关电脑
    private int habit = (int)(Math.random()*10);
    //private int habit = (int)Math.random()*10;不带括号会使随机的值总是为0
    public Student(){}
    public Student(String name){
        this.name = name;
    }
    public void useComputer(Computer computer){
        System.out.println(this.name+"开始使用电脑啦");
        computer.beTurnOn();
        computer.beUsing();
        if(this.habit<5) {
            computer.beTurnOff();
        }else{
            System.out.println(this.name+"习惯不好，用完没有关电脑");
            //这里设计的逻辑不太好
            //一名同学是否使用电脑应当取决于该电脑前是否有其他同学使用
            //而不是上一个同学有没有关电脑
            //但是由于所学内容有限，代码先这样写
        }
    }
    public String getName(){
        return this.name;
    }
}
