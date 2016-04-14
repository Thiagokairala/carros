package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import carros.dao.security.UsuarioDao;
import carros.entities.security.TrocaDeSenha;
import carros.entities.usuarios.Usuario;
import carros.exception.SenhaNaoConfere;
import carros.services.security.password.PasswordHandler;

@Service
public class UsuarioCrudService {
	private UsuarioDao usuarioDao;
	private PasswordHandler passwordHandler;

	public Usuario inserirUsuario(Usuario usuario) throws Exception {
		return usuarioDao.inserirUsuario(usuario);
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Usuario trocarStatusUsuario(Usuario usuario) {
		usuario.setAtivo(!usuario.isAtivo());
		usuarioDao.trocarStatusUsuairo(usuario);
		return usuario;
	}

	public void trocarSenha(TrocaDeSenha trocaDeSenha) throws SenhaNaoConfere {
		try {
			usuarioDao.verificarSenhaAtual(trocaDeSenha.getIdUsuario(),
					this.passwordHandler.criptografarSenha(trocaDeSenha.getSenhaAntiga()));
			usuarioDao.trocarSenha(trocaDeSenha.getIdUsuario(),
					this.passwordHandler.criptografarSenha(trocaDeSenha.getSenhaNova()));
		} catch (EmptyResultDataAccessException e) {
			throw new SenhaNaoConfere();
		}
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}

}
