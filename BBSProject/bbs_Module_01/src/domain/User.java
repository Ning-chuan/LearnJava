package domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String nickName;
    private String address;
    private String registerDate;
    private String birthday;
    private Integer score;
    private String grade;

    public User() {}
    public User(Integer id, String username, String password, String sex, String nickName, String address, String registerDate, String birthday, Integer score, String grade) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.nickName = nickName;
        this.address = address;
        this.registerDate = registerDate;
        this.birthday = birthday;
        this.score = score;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
