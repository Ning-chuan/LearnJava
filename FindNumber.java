public class FindNumber{
	public static void main(String[]args){
		for(int num=100;num<=999;num++){
			if(Math.pow(num/100,3)+Math.pow(num%100/10,3)+Math.pow(num%10,3)==num){
				System.out.println(num+"是水仙花数");
			}
		}
	}
}