package season;

/**
 * 使用enum关键字定义枚举类  JDK5.0之后的做法
 * 使用enum关键字 默认继承Enum类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        System.out.println("Season1的父类是："+Season1.class.getSuperclass());
        System.out.println("Season1的父类的父类是："+Season1.class.getSuperclass().getSuperclass());
        System.out.println("====================");


        Season1[] values = Season1.values();
        for(Season1 season:values){
            System.out.println(season);
            season.show();
        }

        System.out.println("===================");

        Thread.State[] values1 = Thread.State.values();
        for(Thread.State state:values1){
            System.out.println(state);
        }
    }
}
interface Info{
    void show();
}
enum Season1 implements Info{


    //四个季节实例 共有静态保证外部可以直接通过类获取 final保证不可更改
    SPRING("春天", "春暖花开"){
        public void show(){
            System.out.println("春天来啦");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        public void show(){
            System.out.println("夏天夏天悄悄过去留下小秘密");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        public void show(){
            System.out.println("秋天的回忆");
        }
    },
    WINTER("冬天", "冰天雪地"){
        public void show(){
            System.out.println("大约在冬季");
        }
    };
    /*
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");
     */

    //不可更改的成员变量（构造器里赋值）
    private final String seasonName;
    private final String seasonDesc;

    //私有化构造器，不让在外部创建对象
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

//    @Override
//    public void show() {
//        System.out.println(seasonName+"到了");
//    }
}

