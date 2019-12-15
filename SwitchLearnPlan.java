import java.util.Scanner;

public class SwitchLearnPlan{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("请在一周内选一天，我来帮您安排学习内容");
		int day = input.nextInt();
		switch(day){
			case 1:
			case 3:
			case 5:
				System.out.println("学习编程");
				break;
			case 2:
			case 4:
			case 6:
				System.out.println("学习英语");
				break;
			case 7:
				System.out.println("用英语学习编程");
				break;
			default:
				System.out.println("挣到一百万了吗，就想偷懒？");
				break;
		}
	}
}