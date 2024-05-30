package day2;

public class Pattern13 {

	public static void main(String[] args) {
//		1 
//		2 2 
//		3 3 3 
//		4 4 4 4 
//		5 5 5 5 5 
		int row=5;
		for(int i=0;i<row;i++) {
			int k=i+1;
			for(int j=0;j<=i;j++) {
				System.out.print(k+" ");
			}
			System.out.println();
		
		}

	}

}
