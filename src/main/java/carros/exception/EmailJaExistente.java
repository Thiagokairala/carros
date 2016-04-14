package carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Email")
public class EmailJaExistente extends Exception {

	private static final long serialVersionUID = 1L;

}
