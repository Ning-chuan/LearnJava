package service;

import dao.CommodityDao;
import domain.Commodity;
import util.MySpring;

import java.util.ArrayList;

public class CommodityService {

    CommodityDao dao = MySpring.getBean("dao.CommodityDao");

    //获取一类商品
    public ArrayList<Commodity> selectCommodity(Integer kid){
        //调用dao层方法
        return dao.selectCommodity(kid);
    }

}
