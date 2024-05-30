package day2;

import java.util.Scanner;

public class Pattern04 {
public static void main(String[] args) {
//	 *
//	 * *
//	 * * * 
//	 * * * *
//	 * * * * *
		Scanner sc=new Scanner(System.in);
		System.out.println("enter row size");
   int row=sc.nextInt();
//	System.out.println("enter colum size");
// int colum=sc.nextInt();
// 
   for(int i=0;i<row;i++) {
	   for(int j=0;j<=i;j++) {
		   System.out.print("*");
	   }
	   System.out.println();
   }
}
}
