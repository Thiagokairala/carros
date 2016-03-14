package carros.exception;

public class CarrosException extends Exception{

	private static final long serialVersionUID = -3763594412521714535L;

	public CarrosException() {
		super();
	}

	public CarrosException(String message) {
		super(message);
	}

	public CarrosException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarrosException(Throwable cause) {
		super(cause);
	}
}
