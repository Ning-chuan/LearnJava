package damain;

public class Dept {
    private Integer deptno;
    private String deptcme;
    private String loc;

    public Dept(){}
    public Dept(Integer deptno, String deptcme, String loc) {
        this.deptno = deptno;
        this.deptcme = deptcme;
        this.loc = loc;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.deptno);
        builder.append(",");
        builder.append(this.deptcme);
        builder.append(",");
        builder.append(this.loc);
        builder.append("}");
        return builder.toString();
    }


    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptcme() {
        return deptcme;
    }

    public void setDeptcme(String deptcme) {
        this.deptcme = deptcme;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
