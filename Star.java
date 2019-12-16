import java.util.Scanner;

public class Star{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		System.out.println("ÄúÏë»­¼¸ĞĞĞÇĞÇÄØ£¿");
		int line = input.nextInt();
		for(int i=1;i<=line;i++){
			if(i==1){
				for(int j=1;j<=2*line-1;j++){
					System.out.print("*");
				}
			}else{
				for(int j=1;j<=line+1-i;j++){
					System.out.print("*");
				}
				for(int j=1;j<=2*i-3;j++){
					System.out.print(" ");
				}
				for(int j=1;j<=line+1-i;j++){
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}