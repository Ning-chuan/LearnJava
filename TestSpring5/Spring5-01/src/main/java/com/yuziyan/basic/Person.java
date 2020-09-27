package com.yuziyan.basic;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

    private String name;
    private Integer age;

    private String[] emails;
    private Set<String> tels;
    private List<String> address;
    private Map<String,String> qqs;
    private Properties p;

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public Person() {
        System.out.println("Person.Person");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
