package carros.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import carros.exception.CarrosException;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Este usuario ainda não confirmou o email")
public class CarrosUsuarioNaoAutenticado extends CarrosException {
	private static final long serialVersionUID = -1347062466001807350L;

	public CarrosUsuarioNaoAutenticado() {
		super();
	}

	public CarrosUsuarioNaoAutenticado(String message) {
		super(message);
	}

	public CarrosUsuarioNaoAutenticado(String message, Throwable cause) {
		super(message, cause);
	}

	public CarrosUsuarioNaoAutenticado(Throwable cause) {
		super(cause);
	}
}
