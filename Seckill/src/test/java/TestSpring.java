import cn.hutool.crypto.digest.DigestUtil;
import com.yuziyan.seckill.dao.RedisDao;
import com.yuziyan.seckill.dao.SeckillOrderDao;
import com.yuziyan.seckill.dao.UserDao;
import com.yuziyan.seckill.entity.SeckillItem;
import com.yuziyan.seckill.entity.SeckillOrder;
import com.yuziyan.seckill.entity.User;
import com.yuziyan.seckill.service.SeckillItemService;
import com.yuziyan.seckill.service.UserService;
import com.yuziyan.seckill.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class TestSpring {
    
    @Autowired
    UserService userService;
    
    @Autowired
    SeckillItemService seckillItemService;

    @Autowired
    UserDao userDao;

    @Autowired
    RedisDao redisDao;

    @Autowired
    SeckillOrderDao seckillOrderDao;
    
    /**
     * 用于测试：spring-test使用
     */
    @Test
    public void test(){
        User user = userService.getUser(1);
        System.out.println("user = " + user);
    }
    
    /**
     * 用于测试：userDao.getUserByNameAndPassword()方法
     */
    @Test
    public void test1(){
        User user = userDao.getUserByNameAndPassword("张三", "333");
        System.out.println("user = " + user);
    }

    /**
     * 用于测试：userDao.addUser()方法
     */
    @Test
    public void test3(){
        User user = new User();
        user.setName("于自言");
        user.setPassword(DigestUtil.md5Hex("123456"));
        user.setPhone("13112341234");
        int i = userDao.addUser(user);
        System.out.println("i = " + i);
    }
    
    
    /**
     * 用于测试：seckillItemService.getSeckillItemList()方法
     */
    @Test
    public void test4(){
        List<SeckillItem> seckillItemList = seckillItemService.getSeckillItemList();
        for (SeckillItem seckillItem : seckillItemList) {
            System.out.println("seckillItem = " + seckillItem);
        }
    }

    /**
     * 用于测试：seckillItemService.getSeckillItem()方法
     */
    @Test
    public void test5(){
        SeckillItem seckillItem = seckillItemService.getSeckillItem(1);
        System.out.println("seckillItem = " + seckillItem);
    }

    /**
     * 用于测试：redis减库存的方法
     */
    @Test
    public void test6(){
        Integer res = redisDao.reduceStock("stock_1");
        System.out.println("res = " + res);
    }

    /**
     * 用于测试：seckillItemDao.updateStock()方法
     */
    @Test
    public void test7(){
        seckillItemService.updateMySQLStock(-1, 1);

    }

    /**
     * 用于测试：添加秒杀订单方法
     */
    @Test
    public void test8(){
        seckillOrderDao.addSeckillOrder(new SeckillOrder(1,1,1,new Date()));
    }

}
