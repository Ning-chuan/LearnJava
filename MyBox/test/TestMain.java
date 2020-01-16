package test;

import util.*;

public class TestMain {
    public static void main(String[] args){
        ArrayBox ab = new ArrayBox();
        ab.add(5);
        ab.get(0);
        ab.remove(0);
        ab.size();
        LinkedBox lb = new LinkedBox();
        lb.add(5);
        int value= lb.get(0);
        lb.remove(0);
        lb.size();
        System.out.println(value);
    }
}
