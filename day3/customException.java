package day3;

public class customException extends RuntimeException {

	 
	private static final long serialVersionUID = 1L;
	public customException() {
		super();
	}
	public customException(String message) {
		super(message);
	}
}
