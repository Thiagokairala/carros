package carros.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import carros.exception.CarrosException;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Este usuário não possui o perfil correto, ou não está logado")
public class CarrosUsuarioNaoAutorizadoException extends CarrosException {

	private static final long serialVersionUID = 7226352025754512470L;

	public CarrosUsuarioNaoAutorizadoException() {
		super();
	}

	public CarrosUsuarioNaoAutorizadoException(String message) {
		super(message);
	}

	public CarrosUsuarioNaoAutorizadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarrosUsuarioNaoAutorizadoException(Throwable cause) {
		super(cause);
	}
}
