package computerroom;

public class ComputerRoom {
    public int size = 5;
    public Computer[] computer = new Computer[size];
    {//构造方法用于在创建机房对象之前初始化，
        for(int i=0;i<size;i++){
            computer[i] = new Computer(i+1);

        }
    }
    public void welcomeStudentsUseComputer(Student student){
        System.out.println("欢迎"+student.getName()+"同学进入机房");
        for(int i=0;i<computer.length;i++) {
            if(computer[i].getCondition().equals("关闭")) {
                student.useComputer(computer[i]);
                break;
            }
        }
    }
}
