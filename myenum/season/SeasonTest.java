package season;

/**
 * 自定义枚举类 JDK5.0之前的做法
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);
    }
}
class Season{

    //不可更改的成员变量（构造器里赋值）
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器，不让在外部创建对象
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //四个季节实例 共有静态保证外部可以直接通过类获取 final保证不可更改
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
