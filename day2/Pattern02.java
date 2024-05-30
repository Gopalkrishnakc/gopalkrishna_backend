package day2;

import java.util.Scanner;

public class Pattern02 {

	public static void main(String[] args) {
		//a a a a a
//		b b b b b 
//		c c c c c
//		d d d d d
	
		Scanner sc=new Scanner(System.in);
		System.out.println("enter row size");
      int row=sc.nextInt();
  	System.out.println("enter colum size");
    int colum=sc.nextInt();
    char c='a';
    for(int i=0;i<row;i++) {
    	
    	for(int j=0;j<colum;j++) {
    		System.out.print(c+ " ");
    	}
    	
    	System.out.println();
    	c++;
    }
	}

}
