import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 测试JDK内置函数式接口
 */
public class FunctionInterfaceTest {
    /**
     * 用于测试：消费型接口 Consumer<T>  需要一个参数，什么也不返回
     */
    @Test
    public void testConsumer(){
        //以前的写法：
        happyTime(500D, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习累了，去天上人间买了瓶矿泉水，休息一下，花了"+aDouble+"元");
            }
        });
        System.out.println("==============================");
        //lambda表达式写法：
        happyTime(600D,(money)-> System.out.println("学习累了，去天上人间买了瓶矿泉水，休息一下，花了"+money+"元"));
    }

    private void happyTime(Double money,Consumer<Double> consumer){
        consumer.accept(money);
    }

    /**
     * 用于测试：供给型接口Supplier<T>  不需要参数，返回T
     */
    @Test
    public void testSupplier(){
        //以前的写法：
        String mm = getMM(new Supplier<String>() {
            @Override
            public String get() {
                return "范冰冰";
            }
        });
        System.out.println("mm = " + mm);

        System.out.println("=========================");
        //lambda表达式写法：
        String mm1 = getMM(() -> "高圆圆");
        System.out.println("mm1 = " + mm1);

    }
    
    private String getMM(Supplier<String> supplier){
        return supplier.get();
    }

    /**
     * 用于测试：断定型接口Predicate<T> 需要一个参数T 返回一个布尔值
     */
    @Test
    public void testPredicate(){
        //以前的写法：
        List<String> stringList = Arrays.asList("北京", "西京", "东京", "天津", "普京");
        List resList = filterStr(stringList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println("resList = " + resList);

        System.out.println("=================================");

        //lambda表达式写法：
        List resList1 = filterStr(stringList, (s) -> s.contains("京"));
        System.out.println("resList1 = " + resList1);
    }
    
    private List<String> filterStr(List<String> list,Predicate<String> pre){
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                res.add(s);
            }
        }
        return res;
    }
}
