package domain;

import java.util.Date;

public class Post {
    private Integer id;
    private String title;
    private String content;
    private String emotion;
    private User author;
    private Date date;
    private String status;
    private Board board;


    public Post(){}
    public Post(Integer id, String title, String content, String emotion, User author, Date date, String status, Board board) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.emotion = emotion;
        this.author = author;
        this.date = date;
        this.status = status;
        this.board = board;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
