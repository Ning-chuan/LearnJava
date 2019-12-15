import java.util.Scanner;

public class SwitchGrade{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个学生成绩，我来判断区间");
		int score = input.nextInt();
		switch(score/10){
		case 0:
			System.out.println("一定是特别的缘分!");
			break;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("不及格哦!");
			break;
		case 6:
			System.out.println("及格万岁！");
			break;
		case 7:
			System.out.println("中等");
			break;
		case 8:
			System.out.println("整挺好哦");
			break;
		case 9:
			System.out.println("优秀，可以拿奖学金了！");
			break;
		case 10:
			if(score==100){
				System.out.println("学霸本霸！");
				break;
			}
		default:
			System.out.println("没你这号人~");
			break;
		}
	}
}