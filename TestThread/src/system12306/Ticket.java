package system12306;

public class Ticket {
    private Integer num;
    private String start;
    private String end;
    private Integer price;



    public Ticket() {}
    public Ticket(String start, String end,Integer num, Integer price) {
        this.start = start;
        this.end = end;
        this.num = num;
        this.price = price;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
