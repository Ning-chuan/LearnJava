import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TestSpring {
    /**
     * 用于测试：
     */
    @Test
    public void test1(){
//        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }
}
