package bufferandbuilder;

public class TestStringBuilder {
    public static void main(String[] args) {
        //StringBuilder builder = new StringBuilder();//默认数组长度16
        //StringBuilder builder = new StringBuilder(5);//构建时给定长度
        //StringBuilder builder = new StringBuilder("ABC");//长度为字符串长度加上16 即19
        //System.out.println(builder.length());
        //builder.toString()//将StringBuilder对象转换成String对象

//        String str = "a";
//        long time1 = System.currentTimeMillis();
//        for(int i=0;i<200000;i++){
//            //str+="a";//15642毫秒
//            str=str.concat("a");//7937毫秒
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);

        StringBuilder builder = new StringBuilder("a");//长度17个
        long time1 = System.currentTimeMillis();
        for(int i=0;i<200000;i++){
            builder.append("a");//15毫秒
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);

    }
}
