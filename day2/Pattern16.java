package day2;

public class Pattern16 {

	public static void main(String[] args) {
//		     1 
//		   0 0 0 
//		  1 1 1 1 1 
//		 0 0 0 0 0 0 0 
//		1 1 1 1 1 1 1 1 1 

		int row =5;
		int r=1;
		for(int i=1;i<=row;i++) {
			for(int j=0;j<row-i;j++) {
				System.out.print(" ");
			}
			
			for(int j=0;j<2*i-1;j++) {
				System.out.print(r%2+" ");
			
			}
			r++;
			System.out.println();
		}
	}
}
