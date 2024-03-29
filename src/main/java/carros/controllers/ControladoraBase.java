package carros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import carros.dao.pessoa.LojistaDao;
import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.exception.security.CarrosUsuarioNaoAutorizadoException;
import carros.security.session.UsuarioSessao;
import carros.security.session.UsuarioSessaoFactory;

@Controller
public abstract class ControladoraBase {
	private UsuarioSessaoFactory usuarioSessaoFactory;
	private UsuarioSessao usuarioSessao;

	private UsuarioConcessionariaDao usuarioConcessionariaDao;
	private LojistaDao lojistaDao;

	public void usuarioSessaoEhAdmin() throws Exception {
		if (!validarSessaoUsuario().isAdmin()) {
			throw new CarrosUsuarioNaoAutorizadoException();
		}
	}

	public UsuarioConcessionaria usuarioSessaoEhUsuarioConcessionaria() throws Exception {
		if (!validarSessaoUsuario().isUsuarioConcessionaria()) {
			throw new CarrosUsuarioNaoAutorizadoException();
		}

		return usuarioConcessionariaDao.buscarUsuarioConcessionariaPorIdUsuario(usuarioSessao.getSessionUserId());
	}

	public Lojista usuarioSessaoEhLojista() throws Exception {
		if (!validarSessaoUsuario().isLojista()) {
			throw new CarrosUsuarioNaoAutorizadoException();
		}
		
		return lojistaDao.buscarLojistaPorIdUsuario(usuarioSessao.getSessionUserId());
	}

	public void usuarioSessaoEhConcessionaria() throws Exception {
		if (!validarSessaoUsuario().isConcessionaria()) {
			throw new CarrosUsuarioNaoAutorizadoException();
		}
	}

	public UsuarioSessao validarSessaoUsuario() throws Exception {
		usuarioSessao = usuarioSessaoFactory.createInstance();
		if (usuarioSessao != null && usuarioSessao.getSessionUserId() > 0) {
			return usuarioSessao;
		} else {
			throw new CarrosUsuarioNaoAutorizadoException();
		}
	}

	public UsuarioSessaoFactory getUsuarioSessaoFactory() {
		return usuarioSessaoFactory;
	}

	@Autowired
	public void setUsuarioConcessionaria(UsuarioConcessionariaDao usuarioConcessionariaDao) {
		this.usuarioConcessionariaDao = usuarioConcessionariaDao;
	}

	@Autowired
	public void setUsuarioSessaoFactory(UsuarioSessaoFactory usuarioSessaoFactory) {
		this.usuarioSessaoFactory = usuarioSessaoFactory;
	}

	@Autowired
	public void setLojistaDao(LojistaDao lojistaDao) {
		this.lojistaDao = lojistaDao;
	}

}
