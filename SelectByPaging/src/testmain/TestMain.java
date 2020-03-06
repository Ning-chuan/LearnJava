package testmain;


import damain.Emp;
import dao.EmpDao;

import java.util.ArrayList;
import java.util.HashMap;

public class TestMain {
    public static void main(String[] args){

        EmpDao empDao = new EmpDao();
        ArrayList<HashMap<String,Object>> result = empDao.selectGroupByDeptno();
        for(HashMap<String,Object> map:result){
            System.out.println(map.get("deptno")+"---"+map.get("count(empno)"));
        }



//        EmpDao empDao = new EmpDao();
//        ArrayList<Emp> result = empDao.selectEmpAndDept();
//        for(Emp e:result){
//            System.out.println(e);
//        }

//        Service s = new Service();
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入要查询的页码：");
//        ArrayList<EMP> result = s.selectPage(input.nextInt());
//        for(EMP e:result){
//            System.out.println(e);
//        }


//        EMPdao empdao = new EMPdao();
//        ArrayList<EMP> result = empdao.selectForLike("M");
//        for(EMP e:result){
//            System.out.println(e);
//        }


//        EMPdao empdao = new EMPdao();
//        ArrayList<EMP> result = empdao.selectAllEMP();
//        for(EMP e:result){
//            System.out.println(e);
//        }
    }
}
