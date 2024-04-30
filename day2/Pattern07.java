package day2;

public class Pattern07 {
//	5 4 3 2 1 
//	4 3 2 1 
//	3 2 1 
//	2 1 
//	1 


	public static void main(String[] args) {
	int row=5;
	
	
	for(int i=row;i>=0;i--) {
		for(int j=i;j>0;j--) {
			System.out.print(j +" ");
		}
		System.out.println();
	}

	}

}
