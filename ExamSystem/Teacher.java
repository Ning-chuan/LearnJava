import java.util.ArrayList;

public class Teacher {
    public int check(ArrayList<Question> paper, String[] answers){
        System.out.println("师傅正在批改卷子，稍微一等...");
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            e.printStackTrace();
        }
        int score = 0;
        for(int i=0;i<paper.size();i++){
            if(paper.get(i).getAnswer().equalsIgnoreCase(answers[i])){
                score+=(100/paper.size());
            }
        }
        return score;
    }
}
