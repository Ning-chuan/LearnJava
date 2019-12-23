public class ReordeArray{
	public static void main(String[] args){
		int[] array = {1,5,4,3,6,2,};
		for(int i=0;i<array.length;i++){
			for(int j=5;j>i;j--){
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