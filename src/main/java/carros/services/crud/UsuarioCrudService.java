package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.security.UsuarioDao;
import carros.entities.usuarios.Usuario;
import carros.services.security.password.PasswordHandler;
import carros.util.codificacao.UtilCodificacao;

@Service
public class UsuarioCrudService {
	private UsuarioDao usuarioDao;

	private PasswordHandler passwordHandler;

	public Usuario inserirUsuario(Usuario usuario) {

		usuario.setSenha(this.passwordHandler.criptografarSenha(usuario
				.getSenha()));
		return usuarioDao.inserirUsuario(usuario);
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}

}
