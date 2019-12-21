public class ArraySeparate{
	public static void main(String[] args){
		//给定一个数组a{1,2,3,9,4,5},按照数组中最大值的位置，将数组拆分成两个{1,2,3}{4,5}
		//把数组改成a{1,2,3,4,5,6,16,4,7,9,70,5}好用吗？
		int[] a = new int[]{1,2,3,4,5,6,16,4,7,9,70,5};
		int max =a[0];
		int index = 0;
		for(int i=1;i<a.length;i++){
			if(a[i]>max){
				max=a[i];
				index=i;
			}
		}
		System.out.println("原数组最大值的索引是"+index);
		int[] x = new int[index];
		int[] y = new int[a.length-index-1];
		for(int i=0;i<x.length;i++){
			x[i]=a[i];
		}
		for(int i=0;i<y.length;i++){
			y[i]=a[index+1+i];
		}
		for(int v:x){
			System.out.println(v);
		}
		System.out.println("---------------");
		for(int v:y){
			System.out.println(v);
		}
	}
}