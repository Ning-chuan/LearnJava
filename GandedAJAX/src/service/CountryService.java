package service;

import dao.CountryDao;
import domain.Country;

import java.util.ArrayList;

public class CountryService {

    private CountryDao dao = new CountryDao();

    public ArrayList<Country> selectAllCountry() {
        return dao.selectAllCountry();
    }
}
