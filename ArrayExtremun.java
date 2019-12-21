public class ArrayExtremun{
	public static void main(String[] args){
		int[] a = {1,3,5,7,9,0,2,4,6,8};
		int min = a[0];
		int max = a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]<min){
				min=a[i];
			}
			if(a[i]>max){
				max=a[i];
			}
		}
		System.out.println("最大值为"+max);
		System.out.println("最小值为"+min);
	}
}