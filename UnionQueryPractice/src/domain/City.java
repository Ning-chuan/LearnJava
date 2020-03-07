package domain;

public class City {
    private int cityid;
    private String cityname;
    private int citysize;
    private Area area;

    public City(){}

    public City(int cityid, String cityname, int citysize, Area area) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.citysize = citysize;
        this.area = area;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append(this.cityid);
        builder.append(",");
        builder.append(this.cityname);
        builder.append(",");
        builder.append(this.citysize);
        builder.append(",");
        builder.append(this.area);
        builder.append("}");
        return builder.toString();
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getCitysize() {
        return citysize;
    }

    public void setCitysize(int citysize) {
        this.citysize = citysize;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
