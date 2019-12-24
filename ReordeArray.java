public class ReordeArray{
	public static void main(String[] args){
		int[] array = {1,5,4,3,6,2,10,7,9,8};
		for(int i=1;i<array.length;i++){
			for(int j=array.length-1;j>=i;j--){
				if(array[j]<array[j-1]){
					int x=array[j];
					array[j]=array[j-1];
					array[j-1]=x;
				}
			}
		}
		for(int v:array){
			System.out.println(v);
		}
	}
}