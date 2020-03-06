package service;

import damain.Emp;
import dao.EmpDao;

import java.util.ArrayList;

public class Service {

    private EmpDao empdao = new EmpDao();


//    //设计一个方法 选中某页的内容
//    public ArrayList<Emp> selectPage(int page){
//        //思路：将页码转换成对应的行索引
//        return empdao.selectByPaging((page-1)*5);
//    }

}
