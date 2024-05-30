package day2;

public class Pattern11 {
//	1 
//	2 1 
//	3 2 1 
//	4 3 2 1 
//	5 4 3 2 1 

public static void main(String[] args) {
	int row =5;
	for(int i=0;i<row;i++) {
		int k=i+1;
		for(int j=0;j<=i;j++) {
			System.out.print(k+ " ");
			k--;
		}
		System.out.println();
	}
}
}
