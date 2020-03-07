package domain;

public class Area {
    private int aid;
    private String aname;
    private Country country;

    public Area(){}

    public Area(int aid, String aname, Country country) {
        this.aid = aid;
        this.aname = aname;
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.aid);
        builder.append(",");
        builder.append(this.aname);
        builder.append(",");
        builder.append(this.country);
        builder.append("}");
        return builder.toString();
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
