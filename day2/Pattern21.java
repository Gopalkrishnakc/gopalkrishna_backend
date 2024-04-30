package day2;

public class Pattern21 {

	public static void main(String[] args) {
//		1 1 1  1 1
//		2 2 2 2 2 
//		3 3 3 3 3

		
		int row=5;
		int colum=5;
		for(int i=1;i<=row;i++) {
			for(int j=0;j<colum;j++) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}

		
	}

}
