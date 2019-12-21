public class PrimeNumber{
	public static void main(String[]args){
		/*for(int num =2;num<=99;num++){
			int i =2;
			for(;i<=7;i++){
				if(num%i==0 && num!=i){
					System.out.println(num+"不是素数");
					break;//当满足条件时中断循环，并非中断if
				}
			}
			if(i==8){
				System.out.println(num+"是素数");
			}
		}*/
		for(int num =2;num<=99;num++){
			boolean x = false;
			for(int i =2;i<=num/2;i++){
				if(num%i==0){
					System.out.println(num+"不是素数");
					x=true;
					break;//当满足条件时中断循环，并非中断if
				}
			}
			if(!x){//!x<==>x==false
				System.out.println(num+"是素数");
			}
		}
	}
}