public class Break{
	public static void main(String[]args){
		int i=1;
		int j=1;
		for(;i<=5;i++){
			for(;j<=5;j++){
				if(j==3){
					break;
				}
				System.out.println("星光荡开宇宙");
			}
		}
		System.out.println("i的值为"+i);
		System.out.println("j的值为"+j);
		/*
		for(int i=1;i<=5;i++){
			for(int j=1;j<=5;j++){
				if(j==3){
					break;
				}
				System.out.println("星光荡开宇宙");
			}
		}
		*/
	}
}