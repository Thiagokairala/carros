package carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "password nao confere")
public class SenhaNaoConfere extends Exception {

	private static final long serialVersionUID = 1L;

}
