package day2;

public class Pattern20 {

	public static void main(String[] args) {
		int row=5;
		for(int i=0;i<row;i++) {
			for(int j=1;j<row-i;j++) {
				System.out.print(" ");
			}
			int k=i+1;
			for(int j=0;j<=i;j++) {
				
				System.out.print(k);
				k--;
			}
			System.out.println();
		}

	}

}
