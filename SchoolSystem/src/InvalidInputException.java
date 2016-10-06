
public class InvalidInputException extends Exception {

	public InvalidInputException() {
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable arg0) {
		super(arg0);
	}

	public InvalidInputException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidInputException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
