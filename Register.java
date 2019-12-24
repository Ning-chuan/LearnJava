import java.util.Scanner;

public class Register{
	public static void main(String[] args){
		String[] userBox = {"宁川","西安科技大学","建筑设计"};
		int[] passwordBox = {666,111,555};
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的用户名：");
		String name = input.nextLine();
		System.out.println("请输入您的密码：");
		int password = input.nextInt();
		boolean b = true;
		for(int i=0;i<userBox.length;i++){
			if(name.equals(userBox[i])){
				if(password==passwordBox[i]){
					System.out.println("登入成功");
					b=false;
				}
				break;
			}
		}
		if(b){
			System.out.println("用户名或密码错误");
		}
		/*
		for(int i=0;i<userBox.length;i++){
			if(name.equals(userBox[i])){
				if(password==passwordBox[i]){
					System.out.println("登入成功");
				}else if(password!=passwordBox[i]){
					System.out.println("用户名或密码错误");//保障账号安全
					//System.out.println("密码错误");
				}
				break;
			}else if(i==userBox.length-1){
				System.out.println("用户名或密码错误");
			}
		}
		*/
	}
}