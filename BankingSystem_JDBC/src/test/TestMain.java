package test;

import service.Service;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args){
        Service s = new Service();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        if(s.login(name,password).equals("登陆成功")){
            System.out.println("登陆成功！");
            System.out.println("欢迎进入宇哥银行系统");
            while(true) {
                System.out.println("请输入操作项：1、查询余额；2、存款；3、取款；4、转账；5、销户；6、开户；0、退出");
                String option = input.nextLine();
                if(option.equals("0")){
                    break;
                }
                switch (option) {
                    case "1":
                        float balance = s.checkBalance(name);
                        System.out.println(balance);
                        break;
                    case "2":
                        System.out.println("请输入存款金额：");
                        String depositMoney = input.nextLine();
                        System.out.println(s.depositMoney(name,Float.parseFloat(depositMoney)));
                        break;
                    case "3":
                        System.out.println("请输入取款金额：");
                        String withdrawMoney = input.nextLine();
                        System.out.println(s.withdrawMoney(name,Float.parseFloat(withdrawMoney)));
                        break;
                    case "4":
                        System.out.println("请输入转入账户：");
                        String inName = input.nextLine();
                        System.out.println("请输入转账金额：");
                        String transferMoney  = input.nextLine();
                        s.transferMoney(name,inName,Float.parseFloat(transferMoney));
                        break;
                    case "5":
                        s.closeAnAccount(name);
                        break;
                    case "6":
                        System.out.println("请输入账户名：");
                        String newName = input.nextLine();
                        System.out.println("请输入密码：");
                        String newPassword = input.nextLine();
                        System.out.println("请输入金额：");
                        String newMoney  = input.nextLine();
                        s.openAnAccount(newName,newPassword,Float.parseFloat(newMoney));
                        break;
                }
            }
        }
    }
}
