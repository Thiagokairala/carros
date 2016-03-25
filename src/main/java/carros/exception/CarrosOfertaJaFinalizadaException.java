package carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = "Esta oferta já foi finalizada")
public class CarrosOfertaJaFinalizadaException extends CarrosException {

	private static final long serialVersionUID = 2760239535067531483L;


	public CarrosOfertaJaFinalizadaException() {
		super();
	}

	public CarrosOfertaJaFinalizadaException(String message) {
		super(message);
	}

	public CarrosOfertaJaFinalizadaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarrosOfertaJaFinalizadaException(Throwable cause) {
		super(cause);
	}

}
