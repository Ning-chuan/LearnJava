import java.util.Scanner;

public class DiceGame{
	public static void main(String[]args){
		double value = Math.random();//Math可以随机产生一个数，且范围是[0.0~1.0)
		//Math相当于在java的桌面上，不用import就可以直接用
		int number = (int)(value*6+1);//把范围改成一到六的整数
		Scanner input = new Scanner(System.in);
		System.out.println("买大买小，买定离手");
		String choose = input.nextLine();//读取文字
		System.out.println("本次摇出的点数是:"+number);
		if((number<4 && choose.equals("小")) || (number>3 && choose.equals("大"))){
			System.out.println("恭喜您，猜对了");
		}else{
			System.out.println("抱歉，您的答案不对，罚您跳舞。");
		}
	}
}