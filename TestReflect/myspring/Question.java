package myspring;

public class Question {
    private String title;
    private String answer;

    public String toString(){
        return this.title+"\n"+this.answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
