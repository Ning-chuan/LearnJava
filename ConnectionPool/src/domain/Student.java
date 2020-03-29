package domain;

public class Student {
    private Integer sid;
    private String sname;
    private String sex;
    private Integer sage;
    public Student() {

    }
    public Student(Integer sid, String sname, String sex, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.sage = sage;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
}
