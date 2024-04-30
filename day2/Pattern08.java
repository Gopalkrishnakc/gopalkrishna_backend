package day2;

public class Pattern08 {
	
public static void main(String[] args) {
//	5 5 5 5 5 
//	4 4 4 4 
//	3 3 3 
//	2 2 
//	1 

	int row=5;
	for(int i=row;i>=0;i--) {
		for(int j=0;j<i;j++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
}
