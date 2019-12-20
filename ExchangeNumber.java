public class ExchangeNumber{
	public static void main(String[] args){
		int[] a = {1,2,3,4};
		int[] b = {5,6,7,8};
		for(int i=0;i<4;i++){
			a[i]=a[i]^b[i];
			b[i]=a[i]^b[i];
			a[i]=a[i]^b[i];
		}
		/*
		for(int i:a){
			System.out.println(i);
		}
		for(int i:b){
			System.out.println(i);
		}
		*/
	}
}