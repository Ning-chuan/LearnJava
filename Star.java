public class Star{
	public static void main(String[]args){
		for(int i=1;i<=4;i++){
			if(i==1){
				System.out.print("*******");
			}else{
				for(int j=1;j<=5-i;j++){
					System.out.print("*");
				}
				for(int j=1;j<=2*i-3;j++){
					System.out.print(" ");
				}
				for(int j=1;j<=5-i;j++){
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}