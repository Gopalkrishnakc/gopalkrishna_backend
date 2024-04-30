package day2;

import java.util.Scanner;

public class Pattern5 {

	public static void main(String[] args) {
//		 * * * * *
//		 * * * *
//		 * * * 
//		 * *
//		 *
		Scanner sc=new Scanner(System.in);
		System.out.println("enter row size");
   int row=sc.nextInt();
   for(int i=row;i>=0;i--) {
	   for(int j=0;j<i;j++) {
		   System.out.print("*" + " ");
	   }
	   System.out.println();
   }
	}

}
