package domain;

import java.util.List;

public class Board {
    private Integer id;
    private String boardName;
    private User master;
    //private Board parentBoard;当前项目不需要
    private List<Board> children;

    public Board(){}
    public Board(Integer id, String boardName, User master, List<Board> children) {
        this.id = id;
        this.boardName = boardName;
        this.master = master;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public List<Board> getChildren() {
        return children;
    }

    public void setChildren(List<Board> children) {
        this.children = children;
    }
}
