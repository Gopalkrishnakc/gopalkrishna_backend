package Patterns;

import java.util.Scanner;

public class Pattern29 {
	public static void main(String[] args) {
  
//        A 
//      A B A 
//    A B C B A 
//  A B C D C B A 
//A B C D E D C B A 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++)
			{
				System.out.print("  ");
			}
			int x=65;
			for(int k=1;k<=i*2-1;k++) {

				if(k<i) {
					System.out.print((char)x+" ");
					x++;
				}
				else{

					System.out.print((char)x+" ");
					x--;
				}
			}
			System.out.println();
		}
	}
}
