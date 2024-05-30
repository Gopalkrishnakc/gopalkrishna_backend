package day2;

public class Pattern23 {
	public static void main(String[] args) {
//		1
//		2 3
//		3 4 5
//		4 5 6 7
		
		
		int row=5;
		int colum=5;
		for(int i=1;i<=row;i++) {
			int k=i;
			for(int j=1;j<=colum;j++) {
				System.out.print(k++ + " ");
			}
			System.out.println();
		}
		
		
	}
}
