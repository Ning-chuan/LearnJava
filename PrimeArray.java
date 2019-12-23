public class PrimeArray{
	public static void main(String[] args){
		//题目：
		//思路二：定义一个长度足够的数组，先把素数填进去，再截掉0元素
		int[] array = new int[50];
		int index = 0;
		for(int num=2;num<100;num++){
			boolean a = false;
			for(int i=2;i<=num/2;i++){
				if(num%i==0){
					//System.out.println(num+"不是素数");
					a=true;
					break;
				}
			}
			if(!a){
				//System.out.println(num+"是素数");
				array[index++]=num;
				//index++;
			}
		}
		int[] primeArray = new int[index];
		for(int i=0;i<primeArray.length;i++){
			primeArray[i]=array[i];
		}
		array=null;//释放内存
		for(int v:primeArray){
			System.out.println(v);
		}
		/*思路一：找到1~100素数个数，即为数组长度，再次找寻素数并依次记入数组中
		int count = 0;
		for(int num=2;num<100;num++){
			boolean a = false;
			for(int i=2;i<=num/2;i++){
				if(num%i==0){
					//System.out.println(num+"不是素数");
					a=true;
					break;
				}
			}
			if(!a){
				//System.out.println(num+"是素数");
				count++;	
			}
		}
		int[] primeArray = new int[count];
		int index = 0;
		for(int num=2;num<100;num++){
			boolean a = false;
			for(int i=2;i<=num/2;i++){
				if(num%i==0){
					//System.out.println(num+"不是素数");
					a=true;
					break;
				}
			}
			if(!a){
				//System.out.println(num+"是素数");
				primeArray[index]=num;
				index++;
			}
		}
		for(int v:primeArray){
			System.out.println(v);
		}
		*/
	}
}