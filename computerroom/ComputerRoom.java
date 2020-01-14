package computerroom;

public class ComputerRoom {
    public int size = 5;
    public Computer[] computer;
    public void putComputer(){
        for(int i=0;i<size;i++){
            computer[i] = new Computer(i+1);

        }
    }
    public void welcomeStudentsUseComputer(Student student){
        System.out.println("欢迎"+student.getName()+"同学进入机房");
        for(int i=0;i<size;i++) {
            if(computer[i].getCondition().equals("关闭")) {
                student.useComputer(computer[i]);
            }
        }
    }
}
