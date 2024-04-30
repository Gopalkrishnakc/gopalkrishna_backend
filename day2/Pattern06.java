package day2;

public class Pattern06 {
//	1 2 3 4 5 
//	1 2 3 4 
//	1 2 3 
//	1 2 
//	1 

public static void main(String[] args) {
	int row=5;
	for(int i=row;i>=0;i--) {
		for(int j=1;j<=i;j++) {
			System.out.print(j + " ");
			
		}
		System.out.println();
	}
}
}
