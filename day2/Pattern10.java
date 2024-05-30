package day2;

public class Pattern10 {

	public static void main(String[] args) {
//		1 2 3 4 5 
//		2 3 4 5 
//		3 4 5 
//		4 5 
//		5 

	int row =5;
		
		for(int i=row;i>=0;i--) {
			int k=5-(i-1);
			for(int j=1;j<=i;j++) {
				
				System.out.print(k+" ");
				k++;
		}
			System.out.println();
			

	}

}

	}


