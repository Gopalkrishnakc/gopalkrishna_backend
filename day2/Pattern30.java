package Patterns;

import java.util.Scanner;

public class Pattern30 {
	public static void main(String[] args) {
		//        A 
		//      B A B 
		//    C B A B C 
		//  D C B A B C D 
		//E D C B A B C D E 


		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++)
			{
				System.out.print("  ");
			}
			int x=65+i-1;
			for(int k=1;k<=i*2-1;k++) {

				if(k<i) {
					System.out.print((char)x+" ");
					x--;
				}
				else{

					System.out.print((char)x+" ");
					x++;
				}
			}
			System.out.println();
		}
	}
}
