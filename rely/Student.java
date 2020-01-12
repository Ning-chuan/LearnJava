package rely;

public class Student {
    public String name;
    public void enterComputerRoom(){
        System.out.println(this.name+"进入机房");
    }
    public void useComputer(){
        ComputerRoom cr = new ComputerRoom();
        this.enterComputerRoom();
        cr.computer.beUsing();
    }
}
