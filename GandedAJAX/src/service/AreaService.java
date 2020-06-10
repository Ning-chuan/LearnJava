package service;

import dao.AreaDao;
import domain.Area;

import java.util.ArrayList;

public class AreaService {
    private AreaDao dao = new AreaDao();
    public ArrayList<Area> selectAreaByCid(Integer cid) {
        return dao.selectAreaByCid(cid);
    }
}
