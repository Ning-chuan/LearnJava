package domain;

public class Country {
    private int cid;
    private String cname;

    public Country(){}

    public Country(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.cid);
        builder.append(",");
        builder.append(this.cname);
        builder.append("}");
        return builder.toString();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
