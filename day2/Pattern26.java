package Day2;

import java.util.Scanner;

public class Pattern26 {
	public static void main(String[] args) {
//        1 
//      2 1 2 
//    3 2 1 2 3 
//  4 3 2 1 2 3 4 
//5 4 3 2 1 2 3 4 5 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n-i;j>=0;j--) {
				System.out.print("  ");
			}
			int x=i;
			for(int k=1;k<=i*2-1;k++) {
				if(k<i) {
					System.out.print(x +" ");
					x--;
				}
				else {
					System.out.print(x+" ");
					x++;
				}

			}
			System.out.println();
		}
	}
}
