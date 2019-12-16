public class SellMelon{
	public static void main(String[]args){
		int sum = 1020;
		int day = 0;
		while(sum>0){
			sum=sum/2-2;
			day++;
			System.out.println(day+"天后还剩"+sum+"西瓜");
		}
		System.out.println("卖完所有西瓜用了"+day+"天");
	}
}