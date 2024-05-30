package Day2;

import java.util.Scanner;

public class Pattern27 {
	public static void main(String[] args) {
//      5 
//    4 5 4 
//  3 4 5 4 3 
//2 3 4 5 4 3 2 
//1 2 3 4 5 4 3 2 1 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++)
			{
				System.out.print("  ");
			}
			int x=n-i+1;
			for(int k=1;k<=i*2-1;k++) {

				if(k<i) {
					System.out.print(x++ +" ");
//					x++;
				}
				else{

					System.out.print(x-- +" ");
//					x--;
				}
			}
			System.out.println();
		}
	}
}
