package day2;

public class Pattern12 {
public static void main(String[] args) {
//	5 
//	5 4 
//	5 4 3 
//	5 4 3 2 
//	5 4 3 2 1 

	int row=5;
	for(int i=0;i<row;i++) {
		int k=5;
		for(int j=0;j<=i;j++) {
			
			System.out.print(k+" ");
			k--;
		}
		System.out.println();
	}
}
}
