package day2;

public class Pattern18 {
public static void main(String[] args) {
//	* * * * * * * 
//	 * * * * * 
//	  * * * 
//	    * 
//	    

	int row=5;
	for(int i=1;i<=row;i++) {
		for(int j=1;j<i;j++) {
			System.out.print(" ");
		}
		for(int j=1;j<row+1-i;j++) {
			System.out.print('*'+" ");
		}
		for(int j=1;j<row-i;j++) {
			System.out.print('*'+" ");
		}
		System.out.println();
	}
}
}
