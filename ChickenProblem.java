public class ChickenProblem{
	public static void main(String[]args){
		for(int num=1;num<50;num++){
			if(num*2+(50-num)*4==160){
				System.out.println("小鸡的数量为"+num);
				System.out.println("兔子的数量为"+(50-num));
			}
		}
	}
}