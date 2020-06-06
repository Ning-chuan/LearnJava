package myannotation;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class AnnotationTest {
    @Test
    public void test(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}

@MyAnnotation(value = "人生的长河，我把酒当歌")
class Person{
    private String name;
    private int age;

    public void eat(){

    }
}
class Student extends Person{
    @Override
    public void eat() {
        super.eat();
    }
}
