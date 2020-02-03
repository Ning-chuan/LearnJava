import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        TestMachine m = new TestMachine();

        //在计算机中创建一个学生
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        Student s = new Student(name,password);

        //生成试卷 让学生考试
        ArrayList<Question> paper = m.getPaper();
        String[] answers = m.exam(s,paper);
//        for(String v:answers){
//            System.out.println(v);
//        }

        //老师批改
        Teacher teacher = new Teacher();
        int score = teacher.check(paper,answers);
        System.out.println("您的最终得分为："+score);
    }
}
