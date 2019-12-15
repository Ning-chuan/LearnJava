public class ProcessProblem{
	public static void main(String[]args){
		for(int x=20;x<200;x++){
			if((x-10)+(x+20)+(2*x)+(x/2)==370){
				System.out.println("甲加工的零件数是"+(x-10));
				System.out.println("乙加工的零件数是"+(x+10));
				System.out.println("丙加工的零件数是"+(x/2));
				System.out.println("丁加工的零件数是"+(2*x));
			}
		}
	}
}