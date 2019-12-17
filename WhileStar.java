import java.util.Scanner;

public class WhileStar{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("您想要画几行星星呢？");
		int line = input.nextInt();
		int i = 1;
		while(i<=line){
			if(i==1){
				int x = 1;
				while(x<=2*line-1){
					System.out.print("*");
					x++;
				}
			}else{
				int j = 1;
				while(j<=line+1-i){
					System.out.print("*");
					j++;
				}
				int k = 1;
				while(k<=2*i-3){
					System.out.print(" ");
					k++;
				}
				int l = 1;
				while(l<=line+1-i){
					System.out.print("*");
					l++;
				}
			}
			System.out.println();
			i++;
		}
	}
}