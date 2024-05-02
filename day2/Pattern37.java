package Patterns;

import java.util.Scanner;

public class Pattern37 {
	public static void main(String[] args) {
//		4 3 2 1 2 3 4 
//		  3 2 1 2 3 
//		    2 1 2 
//		      1 
//		    2 1 2 
//		  3 2 1 2 3 
//		4 3 2 1 2 3 4 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int sp=0,st=n;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sp;j++) 
			{	
				System.out.print("  ");
			}
			int x=st/2+1;
			for(int j=1;j<=st;j++)
			{
				System.out.print(x+" ");
				if(j<=st/2)
					x--;
				else
					x++;
			}
			if(i<=n/2)
			{
				sp++;
				st=st-2;
			}
			else {
				sp--;
				st=st+2;
			}

			System.out.println();
		}
	}
}
