package carros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Este tipo de usuário não possui chat")
public class UsuarioNaoTemChatException extends CarrosException {

	private static final long serialVersionUID = -1182031658664629138L;

}
