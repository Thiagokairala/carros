package carros.services.crud;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import carros.dao.security.UsuarioDao;
import carros.entities.security.TrocaDeSenha;
import carros.entities.usuarios.Usuario;
import carros.exception.SenhaNaoConfere;
import carros.exception.security.CarrosUserNotFound;
import carros.services.external.EmailService;
import carros.services.security.password.PasswordHandler;

@Service
public class UsuarioCrudService {
	private UsuarioDao usuarioDao;
	private PasswordHandler passwordHandler;
	private EmailService emailService;

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

	public void trocarSenhaComHash(TrocaDeSenha trocaDeSenha) throws SenhaNaoConfere {
		try {
			usuarioDao.trocarSenha(trocaDeSenha.getIdUsuario(),
					this.passwordHandler.criptografarSenha(trocaDeSenha.getSenhaNova()));
		} catch (EmptyResultDataAccessException e) {
			throw new SenhaNaoConfere();
		}
	}

	public Usuario buscarUsuarioPorEmail(String email) throws CarrosUserNotFound {
		return usuarioDao.buscarUsuarioPorEmail(email);
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}

	public void enviarEmailAutenticacao(String email, Usuario usuario) {
		String hash = gerarHashEsqueciSenha(email, usuario);
		emailService.sendNewPasswordEmail(hash, email);
	}

	private String gerarHashEsqueciSenha(String email, Usuario usuario) {
		GregorianCalendar greg = new GregorianCalendar();
		String hash = email + greg.getTimeInMillis();
		hash = passwordHandler.criptografarSenha(hash);
		usuarioDao.inserirTokenEsqueciSenha(hash, usuario.getIdUsuario());
		return hash;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public Usuario verificarTokenEsqueciSenha(String token) throws CarrosUserNotFound {
		return usuarioDao.verificarTokenEsqueciSenha(token);
	}

}
