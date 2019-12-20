public class OddNumber{
	public static void main(String[] args){
		int[] odd = new int[50];
		for(int i=0;i<odd.length;i++){
			odd[i] = 2*i+1;
			//System.out.println(odd[i]);
		}
		/*
		for(int j=0;j<odd.length;j++){
			System.out.println(odd[j]);
		}
		*/
		for(int j:odd){
			System.out.println(j);
		}
	}
}