package computerroom;

public class Test0111 {
    public static void main(String[] args){
        ComputerRoom cr = new ComputerRoom();
        Student s1 = new Student("刘一");
        cr.welcomeStudentsUseComputer(s1);
        Student s2 = new Student("陈二");
        cr.welcomeStudentsUseComputer(s2);
        Student s3 = new Student("张三");
        cr.welcomeStudentsUseComputer(s3);
        Student s4 = new Student("李四");
        cr.welcomeStudentsUseComputer(s4);
        Student s5 = new Student("王五");
        cr.welcomeStudentsUseComputer(s5);
        Student s6 = new Student("赵六");
        cr.welcomeStudentsUseComputer(s6);
        Student s7 = new Student("钱七");
        cr.welcomeStudentsUseComputer(s7);
    }
}
