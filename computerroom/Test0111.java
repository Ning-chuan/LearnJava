package computerroom;

public class Test0111 {
    public static void main(String[] args){
        Student s1 = new Student("张三");
        Student s2 = new Student("李四");
        Student s3 = new Student("王五");
        Student s4 = new Student("赵六");
        Student s5 = new Student("钱七");
        ComputerRoom cr = new ComputerRoom();
        cr.welcomeStudentsUseComputer(s1);
    }
}
