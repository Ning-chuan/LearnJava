public class PrimeArray{
	public static void main(String[] args){
		int count = 0;
		boolean a = false;
		for(int num=2;num<100;num++){
			for(int i=2;i<num/2;i++){
				if(num%i==0){
					System.out.println(num+"不是素数");
					a=true;
					break;
				}
			}
			if(!a){
				System.out.println(num+"是素数");
				count++;	
			}
		}
		/*
		int[] primeArray = new int[index];
		int x = 0;
		for(int v:primeArray){
			System.out.println(v);
		}
		*/
	}
}