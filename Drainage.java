public class Drainage{
	public static void main(String[] args){
		int water = 120;
		int hour = 0;
		while(water>0){
			water+=18;
			water-=30;
			hour++;
		}
		System.out.println(hour);
	}
}