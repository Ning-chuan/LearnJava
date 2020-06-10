package domain;

public class City {
    private Integer cityId;
    private String cityName;
    private Integer citySize;
    private Area area;

    public City(){}
    public City(Integer cityId, String cityName, Integer citySize, Area area) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.citySize = citySize;
        this.area = area;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCitySize() {
        return citySize;
    }

    public void setCitySize(Integer citySize) {
        this.citySize = citySize;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
