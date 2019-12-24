import java.util.Scanner;

public class ChangeGroup{
	public static void main(String[] args){
		//模拟班级同学每周换位置
		int[][] group ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Scanner input = new Scanner(System.in);
		System.out.println("请您输入周数，我来输出位置");
		int week = input.nextInt();
		for(int i=1;i<=week%4;i++){
			int[] x=group[3];
			group[3]=group[2];
			group[2]=group[1];
			group[1]=group[0];
			group[0]=x;
		}
		for(int[] v:group){
			for(int z:v){
				System.out.print(z);
			}
			System.out.println();
		}
		/*
		for(int i=0;i<group.length;i++){
			for(int j=0;j<group[i].length;j++){
				System.out.print(group[i][j]);
			}
			System.out.println();
		}
		*/
	}
}