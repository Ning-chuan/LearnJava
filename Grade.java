import java.util.Scanner;

public class Grade{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入一个分数，我来评估等级");
		int grade = input.nextInt();//可以读取输入的文字 
		if(0<=grade && grade<60){
			System.out.println("不及格");
		}else if(60<=grade && grade<70){
			System.out.println("及格");
		}else if(70<=grade && grade<80){
			System.out.println("中");
		}else if(80<=grade && grade<90){
			System.out.println("良");
		}else if(90<=grade && grade<100){
			System.out.println("优秀");
		}else if(grade==100){
			System.out.println("满分");
		}else{
			System.out.println("你不适合学习，放弃吧！");
		}
		
	} 
}