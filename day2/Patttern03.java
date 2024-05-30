package day2;
import java.util.Scanner;

public class Patttern03 {

	public static void main(String[] args) {
//		 5 4 3 2 1
//		 5 4 3 2 1
//		 5 4 3 2 1
//		 5 4 3 2 1
		Scanner sc=new Scanner(System.in);
		System.out.println("enter row size");
      int row=sc.nextInt();
  	System.out.println("enter colum size");
    int colum=sc.nextInt();
    for(int i=0;i<row;i++) {
    	int a=5;
    	for(int j=0;j<colum;j++) {
    		System.out.print(a + " ");
    		a--;
    	}
    	System.out.println();
    }
	}

}
