import java.util.Scanner;

public class NumberPyramid{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入行数，我来生成数字金字塔");
		int line = input.nextInt();
		for(int i=1;i<=line;i++){
			for(int j=1;j<=line-i;j++){
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++){
				System.out.print(j);
			}
			for(int j=i-1;j>=1;j--){
				System.out.print(j);
			}
		System.out.println();
		}
	}
}