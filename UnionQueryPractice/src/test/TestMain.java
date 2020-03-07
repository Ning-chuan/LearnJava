package test;

import dao.Dao;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {
    public static void main(String[] args){

        //第四题
        Dao dao = new Dao();
        ArrayList<HashMap<String,Object>> result = dao.thirdTopic();
        for(HashMap<String,Object> map:result){
            System.out.println(map.get("aname")+"---"+map.get("avg(citysize)"));
        }


//        //第三题
//        Dao dao = new Dao();
//        ArrayList<HashMap<String,Object>> result = dao.thirdTopic();
//        for(HashMap<String,Object> map:result){
//            System.out.println(map.get("aname")+"---"+map.get("avg(citysize)"));
//        }


//        //第二题
//        Dao dao = new Dao();
//        ArrayList<HashMap<String,Object>> result = dao.secondTopic();
//        for(HashMap<String,Object> map:result){
//            System.out.println(map.get("cname")+"---"+map.get("count(cityid)"));
//        }


        //第一题
//        Dao dao = new Dao();
//        ArrayList<HashMap<String,Object>> result = dao.firstTopic();
//        for(HashMap<String,Object> map:result){
//            System.out.println(map.get("cityname")+"---"+map.get("citysize")+"---"+map.get("aname"));
//        }
    }
}
