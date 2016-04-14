package carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "username")
public class NomeDeUsuarioExistente extends Exception {

	private static final long serialVersionUID = -8761375557559343235L;

}
