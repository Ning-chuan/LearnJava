public class ArraySeparate2{
	public static void main(String[] args){
		//按照数组中最大值的位置，将数组拆分
		//a{1,2,6,4,6,5,6,70,4,5,9,70,7}
		int[] a = new int[]{1,2,6,4,6,5,6,70,4,5,9,70,7};
		int max =a[0];
		int[] index = new int[a.length];
		int x = 0;
		for(int i=1;i<a.length;i++){
			if(a[i]>max){
				max=a[i];
				index[x]=i;
			}else if(a[i]==max){
				x++;
				index[x]=i
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