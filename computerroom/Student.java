package computerroom;

public class Student {
    private String name;
    public Student(){}
    public Student(String name){
        this.name = name;
    }
    public void useComputer(Computer computer){
        computer.beTurnOn();
        computer.beUsing();
        computer.beTurnOff();
    }
    public String getName(){
        return this.name;
    }
}
