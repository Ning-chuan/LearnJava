public class ArrayCombine{
	public static void main(String[] args){
		int[] a = new int[]{1,2,3};
		int[] b = new int[]{4,5};
		int[] newArray = new int[a.length+b.length];
		//思路二：分别将a,b数组元素填入新数组中
		for(int i=0;i<a.length;i++){
			newArray[i]=a[i];
		}
		for(int i=0;i<b.length;i++){
			newArray[a.length+i]=b[i];
		}
		/*思路一：将新数组填满
		for(int i=0;i<newArray.length;i++){
			if(i<a.length){
				newArray[i]=a[i];
			}else{
				newArray[i]=b[i-a.length];
			}
		}
		*/
		for(int x:newArray){
			System.out.println(x);
		}
	}
}