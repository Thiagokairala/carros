package carros.services.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.ConcessionariaDao;
import carros.dao.pessoa.LojistaDao;
import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.dao.security.UsuarioDao;
import carros.entities.security.LoginForm;
import carros.entities.usuarios.TipoUsuario;
import carros.entities.usuarios.TipoUsuarioConst;
import carros.entities.usuarios.Usuario;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.exception.security.CarrosUserNotFound;
import carros.exception.security.CarrosUsuarioNaoAutenticado;
import carros.services.security.password.PasswordHandler;

@Service
@Scope("request")
public class LoginUserService {

	private PasswordHandler passwordHandler;
	private UsuarioDao usuarioDao;
	private ConcessionariaDao concessionariaDao;
	private UsuarioConcessionariaDao usuarioConcessionariaDao;
	private LojistaDao lojistaDao;

	public Serializable loginUser(LoginForm loginForm) throws CarrosUserNotFound, CarrosUsuarioNaoAutenticado {
		Usuario usuario;
		loginForm.setPassword(this.passwordHandler.criptografarSenha(loginForm.getPassword()));
		try {
			usuario = usuarioDao.loginUsuario(loginForm);
			if (usuario.isAutenticado()) {
				return getUsuarioCorreto(usuario);
			} else {
				throw new CarrosUsuarioNaoAutenticado("O usuario ainda n�o confirmou o email");
			}

		} catch (EmptyResultDataAccessException e) {
			throw new CarrosUserNotFound("Usu�rio n�o cadastrado o sistema ou a senha n�o confere");
		}
	}

	public Serializable confirmarEmail(String token) throws CarrosUserNotFound {
		Usuario usuario;
		try {
			usuario = usuarioDao.loginUsuario(token);
			if (usuario.getIdUsuario() > 0) {
				usuarioDao.setarAutenticado(usuario.getIdUsuario());
			}

			return getUsuarioCorreto(usuario);
		} catch (EmptyResultDataAccessException e) {
			throw new CarrosUserNotFound("Usu�rio n�o cadastrado o sistema ou a senha n�o confere");
		}
	}

	private Serializable getUsuarioCorreto(Usuario usuario) {
		TipoUsuario tipoUsuario = usuario.getTipoUsuario();
		if (tipoUsuario.getId() == TipoUsuarioConst.ADMIN.getTipoUsuarioConst()) {
			return usuario;
		} else if (tipoUsuario.getId() == TipoUsuarioConst.CONCESSIONARIA.getTipoUsuarioConst()) {
			return concessionariaDao.buscarConcessionariaPorIdUsuario(usuario.getIdUsuario());
		} else if (tipoUsuario.getId() == TipoUsuarioConst.USUARIO_CONCESSIONARIA.getTipoUsuarioConst()) {
			UsuarioConcessionaria usuarioConcessionaria = usuarioConcessionariaDao
					.buscarUsuarioConcessionariaPorIdUsuario(usuario.getIdUsuario());
			usuarioConcessionaria.getConcessionaria().setUsuario(null);
			return usuarioConcessionaria;
		} else if (tipoUsuario.getId() == TipoUsuarioConst.LOJISTA.getTipoUsuarioConst()) {
			return lojistaDao.buscarLojistaPorIdUsuario(usuario.getIdUsuario());
		}
		return null;
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Autowired
	public void setConcessionariaDao(ConcessionariaDao concessionariaDao) {
		this.concessionariaDao = concessionariaDao;
	}

	@Autowired
	public void setUsuarioConcessionariaDao(UsuarioConcessionariaDao usuarioConcessionariaDao) {
		this.usuarioConcessionariaDao = usuarioConcessionariaDao;
	}

	@Autowired
	public void setLojistaDao(LojistaDao lojistaDao) {
		this.lojistaDao = lojistaDao;
	}
}
