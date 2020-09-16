import org.junit.Test;

import java.util.function.Consumer;

/**
 * 测试JDK内置函数式接口
 */
public class FunctionInterfaceTest {
    /**
     * 用于测试：消费型接口 Consumer<T>
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



}
