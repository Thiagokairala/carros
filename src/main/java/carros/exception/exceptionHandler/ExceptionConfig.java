package carros.exception.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import carros.exception.CarrosException;
import carros.exception.EmailJaExistente;
import carros.exception.NomeDeUsuarioExistente;
import carros.exception.SenhaNaoConfere;
import carros.exception.UsuarioNaoTemChatException;
import carros.exception.security.CarrosUserNotFound;
import carros.exception.security.CarrosUsuarioNaoAutenticado;
import carros.exception.security.CarrosUsuarioNaoAutorizadoException;
import carros.exception.security.CarrosUsuarioNaoTemPapel;

@Controller
public class ExceptionConfig {

	@ExceptionHandler(CarrosException.class)
	public @ResponseBody ResponseEntity<String> carrosException() {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CarrosUserNotFound.class)
	public @ResponseBody ResponseEntity<String> carrosUserNotFound() {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NomeDeUsuarioExistente.class)
	public @ResponseBody ResponseEntity<String> nomeDeUsuarioExistente() {
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(CarrosUsuarioNaoTemPapel.class)
	public @ResponseBody ResponseEntity<String> carrosUsuarioNaoTemPapel() {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CarrosUsuarioNaoAutenticado.class)
	public @ResponseBody ResponseEntity<String> carrosUsuarioNaoAutenticado() {
		return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(CarrosUsuarioNaoAutorizadoException.class)
	public @ResponseBody ResponseEntity<String> carrosUsuarioNaoAutorizado() {
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(UsuarioNaoTemChatException.class)
	public @ResponseBody ResponseEntity<String> usuarioNaoTemChat() {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmailJaExistente.class)
	public @ResponseBody ResponseEntity<String> emailJaCadastrado() {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SenhaNaoConfere.class)
	public @ResponseBody ResponseEntity<String> senhaNaoConfere() {
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
	}

}
