package day2;

public class Father extends GrandFather {
	public static void main(String[] args) {
		int numb=2;
		//upcasting
		GrandFather G=new Father();
		
		//Downcasting
		Father F=(Father)G;
		System.out.println(F.number);
	}

}
