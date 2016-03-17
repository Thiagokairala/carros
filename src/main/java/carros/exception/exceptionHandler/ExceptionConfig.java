package carros.exception.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import carros.exception.CarrosException;
import carros.exception.security.CarrosUserNotFound;
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

	@ExceptionHandler(CarrosUsuarioNaoTemPapel.class)
	public @ResponseBody ResponseEntity<String> carrosUsuarioNaoTemPapel() {
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
