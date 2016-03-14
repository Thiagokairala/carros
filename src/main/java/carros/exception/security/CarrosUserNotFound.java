package carros.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import carros.exception.CarrosException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Este usuário não está registrado no sistema")
public class CarrosUserNotFound extends CarrosException {

	private static final long serialVersionUID = 3315798664894896530L;

	public CarrosUserNotFound() {
		super();
	}

	public CarrosUserNotFound(String message) {
		super(message);
	}

	public CarrosUserNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public CarrosUserNotFound(Throwable cause) {
		super(cause);
	}
}
