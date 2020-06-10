package service;

import dao.CityDao;
import domain.City;

import java.util.ArrayList;

public class CityService {
    private CityDao dao = new CityDao();
    public ArrayList<City> selectCityByAid(int aid) {
        return dao.selectCityByAid(aid);
    }
}
