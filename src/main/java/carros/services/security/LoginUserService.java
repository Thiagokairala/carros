package carros.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carros.entities.security.LoginForm;
import carros.services.security.password.PasswordHandler;

@Service
@Scope("request")
public class LoginUserService {

	private PasswordHandler passwordHandler;

	public void loginUser(LoginForm loginForm) {
		System.out.println(this.passwordHandler.criptografarSenha(loginForm
				.getPassword()));
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}
}
