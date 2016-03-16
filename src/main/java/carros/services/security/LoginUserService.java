package carros.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import carros.dao.security.UsuarioDao;
import carros.entities.security.LoginForm;
import carros.entities.usuarios.Usuario;
import carros.services.security.password.PasswordHandler;

@Service
@Scope("request")
public class LoginUserService {

	private PasswordHandler passwordHandler;
	private UsuarioDao usuarioDao;

	public Usuario loginUser(LoginForm loginForm) {
		loginForm.setPassword(this.passwordHandler.criptografarSenha(loginForm
				.getPassword()));
		return usuarioDao.loginUsuario(loginForm);
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	
}
