package day2;

public class Pattern15 {
public static void main(String[] args) {
//	     1 
//	   0 1 0 
//	  1 0 1 0 1 
//	 0 1 0 1 0 1 0 
//	1 0 1 0 1 0 1 0 1 

	int row =5;
	int x=1;
	for(int i=1;i<=row;i++) {
		for(int j=1;j<=row-i;j++ ) {
		System.out.print(" ");	
		}
		
			for(int j=1;j<=2*i-1;j++ ) {
			System.out.print(x%2+" ");	
			x++;
			}
			System.out.println();
	}
}
}
