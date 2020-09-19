import com.yuziyan.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    /**
     * 用于测试：Spring的第一个程序
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object person = ctx.getBean("person");

        System.out.println("person = " + person);
    }
}
