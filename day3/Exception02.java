package day3;

public class Exception02 {

	public static void main(String[] args) {
try {
	runner();
} catch (Exception e) {
	System.out.println("handled throws");
	e.printStackTrace();
}
	}
	
public static void runner() throws Exception {
int num=10;
num /=0;
System.out.println(num);
int password=123;
if(password==123) {
	System.out.println("login sucessful");
}else {
	throw new ArithmeticException("Arithematicexcepion");
}
  
}

}
