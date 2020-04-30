package service;

import dao.KindDao;
import domain.Kind;
import util.MySpring;

import java.util.ArrayList;

public class KindService {

    KindDao kindDao = MySpring.getBean("dao.KindDao");

    public ArrayList<Kind> getAllKinds(){
        return kindDao.selectAllKinds();
    }
}
