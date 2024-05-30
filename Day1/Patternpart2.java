package Day1;

public class patternpart2 {
public static void main(String[] args) {
//		1 2 3 4 5
//		1 2 3 4 5
//		1 2 3 4 5
//		1 2 3 4 5
//		1 2 3 4 5
		int row=5;
		int colum=5;
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=colum;j++) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}

		}
}
