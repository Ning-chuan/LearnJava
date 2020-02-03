import javax.swing.*;
import java.util.*;

public class TestMachine {
    //题库
    //存储Question对象
    //特点 不能重复 set集合 选用HashSet集合
    private HashSet<Question> questionBank = new HashSet<>();
    {//构造方法初始化题库
        questionBank.add(new Question("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A"));
        questionBank.add(new Question("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A"));
        questionBank.add(new Question("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个是java.util包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        questionBank.add(new Question("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        questionBank.add(new Question("以下选项哪个是String类中方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        questionBank.add(new Question("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        questionBank.add(new Question("以下选项哪个不是Set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));
    }

    //生成试卷
    public ArrayList<Question> getPaper(){
        System.out.println("正在生成试卷，稍微一等...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成试卷的题目不可以重复 所以用HashSet存储
        HashSet<Question> paper = new HashSet();
        //题库是用HashSet存储的题目 没有顺序 我们想随机抽取题目需要先把它造型成ArrayList集合
        ArrayList<Question> questionBank = new ArrayList<>(this.questionBank);
        while(paper.size() !=5){
            int index = new Random().nextInt(10);//产生随机数
            paper.add(questionBank.get(index));
        }
        return new ArrayList<>(paper);
    }

    //考试方法：
    public String[] exam(Student s,ArrayList<Question> paper){
        String result = this.login(s.getName(),s.getPassword());
        if(result.equals("登陆成功")) {
            System.out.println("欢迎" + s.getName() + "同学千里迢迢来考试");
            String[] answers = new String[paper.size()];//用于存储答案的的数组
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < paper.size(); i++) {
                System.out.println((i+1)+"."+paper.get(i).getTitle());
                System.out.println("请输入您认为正确的答案：");
                answers[i] = input.nextLine();//把每一次的答案存起来
            }
            return answers;
        }
        return null;
    }

    //用户数据
    private HashMap<String,String> userBox = new HashMap();
    {
        userBox.put("宁川","123");
        userBox.put("西安科技大学","666");
        userBox.put("建筑设计","555");
    }

    //登陆方法：
    public String login(String name,String password){
        if(userBox.get(name)!=null && userBox.get(name).equals(password)){
            return "登陆成功";
        }
        return "用户名或密码错误";
    }
}
