import com.yuziyan.basic.Person;
import com.yuziyan.basic.constructor.Customer;
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
    
    /**
     * 用于测试：Spring工厂的方法
     */
    @Test
    public void test(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //这种方式获取对象，不需要强制类型转换
        Person person = ctx.getBean("person", Person.class);
        System.out.println("person = " + person);

//        //当前Spring的配置文件中 只能有一个<bean class是Person类型
//        Person person1 = ctx.getBean(Person.class);
//        System.out.println("person1 = " + person1);

        //获取配置文件中所有bean标签的id值  person person1
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        //根据类型获取配置文件中对应bean标签的id值
        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
        for (String id : beanNamesForType) {
            System.out.println("id = " + id);
        }

        //用于判断是否存在指定id值的bean
        System.out.println(ctx.containsBeanDefinition("a"));

        //用于判断是否存在指定id值的bean
        System.out.println(ctx.containsBean("person"));

    }
    
    /**
     * 用于测试：只配置了类型的bean，id是多少？
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    /**
     * 用于测试：
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        //通过代码为变量赋值, 存在耦合, 如果以后想修改变量的值, 需要修改代码, 重新编译
        person.setName("于自言");
        person.setAge(16);
        System.out.println("person = " + person);

        Person p = (Person) ctx.getBean("p");
        System.out.println("p = " + p);
    }
    
    /**
     * 用于测试：
     */
    @Test
    public void test4(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println("customer = " + customer);
    }
    
}
