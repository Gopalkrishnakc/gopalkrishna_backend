package day2;

public class Pattern17 {
public static void main(String[] args) {
//	1 
//	2 6 
//	3 7 10 
//	4 8 11 13 
//	5 9 12 14 15 
	int row=5;
	for(int i=1;i<=row;i++) {
		int x=i;
		for(int j=1;j<=i;j++) {
			System.out.print(x+" ");
			x=x+row-j;
		}
		System.out.println();
	}
}
}
