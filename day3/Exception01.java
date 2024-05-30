package day3;

import java.util.Scanner;

public class Exception01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		int num = 10;
		try {
			num /= 0;
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			System.out.println("ArithmeticException resolved");
		} finally {
			sc.close();
		}
		

	}

}
