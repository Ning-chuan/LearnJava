import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.service.UserService;
import com.yuziyan.seckill.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class TestSpring {
    
    @Autowired
    UserService userService;
    
    /**
     * 用于测试：spring-test使用
     */
    @Test
    public void test(){
        User user = userService.getUser(1);
        System.out.println("user = " + user);
    }
    
}
