import java.util.Scanner;

public class TwoArrayRegister{
	public static void main(String[] args){
		//利用二维数组 实现用户登录认证
		String[][] data ={ {"宁川","666"},{"西安科技大学","111"},{"建筑设计","555"}};
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的用户名：");
		String name = input.nextLine();
		System.out.println("请输入密码：");
		String password = input.nextLine();
		boolean b = true;
		for(int i=0;i<data.length;i++){
			if(data[i][0].equals(name)){
				if(data[i][1].equals(password)){
					System.out.println("登陆成功");
					b=false;
				}
				break;
			}
		}
		if(b){
			System.out.println("用户名或密码错误");
		}
	}
}