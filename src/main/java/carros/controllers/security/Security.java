package carros.controllers.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.security.LoginForm;
import carros.entities.usuarios.Usuario;
import carros.services.security.LoginUserService;

@RestController
@RequestMapping("/security")
@Service
@Scope("request")
public class Security {

	private static final Logger logger = LoggerFactory.getLogger(Security.class);

	private LoginUserService LoginUserService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Usuario> login(@RequestBody LoginForm loginForm) {
		logger.info("/security/login");

		return new ResponseEntity<Usuario>(LoginUserService.loginUser(loginForm), HttpStatus.OK);
	}

	@Autowired
	public void setLoginUserService(LoginUserService loginUserService) {
		this.LoginUserService = loginUserService;
	}
}
