package domain;

public class User {
    private String uname;
    private String upassword;
    private String nickname;

    public User(String uname, String upassword, String nickname) {
        this.uname = uname;
        this.upassword = upassword;
        this.nickname = nickname;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getUpassword() {
        return upassword;
    }
    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
