package tp1.p2.control.exceptions;

public class InvalidPositionException extends CommandExecuteException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidPositionException() {super();}
	
	public InvalidPositionException(String message) {super(message);}
	
	public InvalidPositionException(Throwable cause) {super(cause);}
	
	public InvalidPositionException(String message, Throwable cause) {super(message, cause);}
}