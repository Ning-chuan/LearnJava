package test;

import domain.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student student = (Student) factory.getBean("student");
        System.out.println(student);
        System.out.println(student.getSsex().length());
        //默认：单例 立即加载
    }
}
