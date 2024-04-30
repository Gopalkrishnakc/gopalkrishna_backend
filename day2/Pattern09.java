package day2;

public class Pattern09 {

	public static void main(String[] args) {
//		1 1 1 1 1 
//		2 2 2 2 
//		3 3 3 
//		4 4 
//		5 


		int row =5;
		
		for(int i=row;i>=0;i--) {
			
			for(int j=1;j<=i;j++) {
				int k=5-(i-1);
				System.out.print(k+" ");
				k++;
		}
			System.out.println();
			

	}

}
}