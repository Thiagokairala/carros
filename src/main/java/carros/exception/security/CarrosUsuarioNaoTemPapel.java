package carros.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import carros.exception.CarrosException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Este usuário não se enquadra no sistema de papeis(roles)")
public class CarrosUsuarioNaoTemPapel extends CarrosException {

	private static final long serialVersionUID = 5134106831801910470L;

	public CarrosUsuarioNaoTemPapel() {
		super();
	}

	public CarrosUsuarioNaoTemPapel(String message) {
		super(message);
	}

	public CarrosUsuarioNaoTemPapel(String message, Throwable cause) {
		super(message, cause);
	}

	public CarrosUsuarioNaoTemPapel(Throwable cause) {
		super(cause);
	}
}
