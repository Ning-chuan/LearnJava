import java.util.Objects;

public class Question {
    private String title;
    private String answer;
    public Question(String title,String answer){
        this.title = title;
        this.answer = answer;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAnswer(){
        return this.answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Question && this.title.equals(((Question) o).title)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }
}
