public class Meet{
	public static void main(String[]args){
		int distance=1000;
		int hour=0;
		while(distance>0){
			distance-=17;
			distance-=18;
			hour++;
			System.out.println(hour+"小时后两人相距"+distance+"千米");
		}
		System.out.println("小明同学和哥哥相遇用了"+hour+"小时");
	}
}