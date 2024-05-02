package Day2;

import java.util.Scanner;

public class Pattern25 {
//	    1 
//      1 2 1 
//    1 2 3 2 1 
//  1 2 3 4 3 2 1 
//1 2 3 4 5 4 3 2 1 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n-i;j>=0;j--) {
				System.out.print("  ");
			}
			int x=1;
			for(int k=1;k<=i*2-1;k++) {
				if(k<i) {
					System.out.print(x +" ");
					x++;
				}
				else {
					System.out.print(x+" ");
					x--;
				}

			}
//			 for (int k = 1; k <= i; k++) {
//	                System.out.print(k + " ");
//	                x++;
//	            }
//	            for (int k = i - 1; k >= 1; k--) {
//	                System.out.print(k + " ");
//	            }
			System.out.println();


		}
	}
}
