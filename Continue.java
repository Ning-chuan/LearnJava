public class Continue{
	public static void main(String[]args){
		ok:for(int i=1;i<=5;i++){
			ko:for(int j=1;j<=5;j++){
				if(j==3){
					continue ok;//标记那个，跳过那个。
				}
				System.out.println("星光荡开宇宙");
			}
		}
		/*
		int i=1;
		int j=1;
		for(;i<=5;i++){
			for(;j<=5;j++){
				if(j==3){
					continue;//没有标记时遵守就近原则
				}
				System.out.println("星光荡开宇宙");
			}
		}
		System.out.println("i的值为"+i);
		System.out.println("j的值为"+j);
		*/
	}
}