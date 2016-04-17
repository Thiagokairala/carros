package carros.dao.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.pessoa.PessoaDao;
import carros.dao.security.extractor.UsuarioRowMapper;
import carros.entities.pessoas.Pessoa;
import carros.entities.security.LoginForm;
import carros.entities.usuarios.Usuario;
import carros.exception.EmailJaExistente;
import carros.exception.NomeDeUsuarioExistente;
import carros.exception.security.CarrosUserNotFound;
import carros.services.security.password.PasswordHandler;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private JdbcTemplate jdbcTemplate;
	private PessoaDao pessoaDao;
	private PasswordHandler passwordHandler;
	private UsuarioRowMapper usuarioRowMapper;

	@Override
	public Usuario inserirUsuario(Usuario usuario) throws Exception {
		return inserirUsuarioPrivate(usuario, UsuarioDaoContrato.INSERIR_USUARIO);
	}
	@Override
	public Usuario inserirUsuario(Usuario usuario, boolean alreadyAutenticated)
			throws EmailJaExistente, NomeDeUsuarioExistente {
		
		return inserirUsuarioPrivate(usuario, UsuarioDaoContrato.INSERIR_USUARIO_JA_AUTENTICADO);
	}


	private Usuario inserirUsuarioPrivate(Usuario usuario, String iNSERIR_USUARIO) throws EmailJaExistente, NomeDeUsuarioExistente {
		chekEmail(usuario.getEmail());
		checkUsrname(usuario.getUsername());
		Pessoa pessoa = pessoaDao.inserirPessoa(usuario.getPessoa());

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		usuario.setSenha(this.passwordHandler.criptografarSenha(usuario.getSenha()));
		usuario.setTokenAutenticacao(
				passwordHandler.criptografarSenha(usuario.getEmail()) + gregorianCalendar.getTimeInMillis());

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(UsuarioDaoContrato.INSERIR_USUARIO,
						new String[] { "id" });
				stmt.setString(1, usuario.getUsername());
				stmt.setString(2, usuario.getSenha());
				stmt.setLong(3, pessoa.getIdPessoa());
				stmt.setString(4, usuario.getEmail());
				stmt.setLong(5, usuario.getTipoUsuario().getId());
				stmt.setString(6, usuario.getTokenAutenticacao());

				return stmt;
			}
		}, keyHolder);

		usuario.setIdUsuario((Long) keyHolder.getKey());
		return usuario;
	}

	private void checkUsrname(String username) throws NomeDeUsuarioExistente {
		try {
			jdbcTemplate.queryForObject(UsuarioDaoContrato.BUSCAR_USERNAME, usuarioRowMapper,
					new Object[] { username });
			throw new NomeDeUsuarioExistente();
		} catch (EmptyResultDataAccessException e) {
			// nothgin to do.
		}
	}

	private void chekEmail(String email) throws EmailJaExistente {
		try {
			jdbcTemplate.queryForObject(UsuarioDaoContrato.BUSCAR_EMAIL, usuarioRowMapper, new Object[] { email });
			throw new EmailJaExistente();
		} catch (EmptyResultDataAccessException e) {
			// nothgin to do.
		}

	}

	@Override
	public Usuario loginUsuario(LoginForm loginForm) {
		Object[] arrayParams = new Object[] { loginForm.getUsername(), loginForm.getPassword() };
		Usuario usuario = jdbcTemplate.queryForObject(UsuarioDaoContrato.BUSCAR_USUARIO, arrayParams, usuarioRowMapper);
		return usuario;
	}

	@Override
	public Usuario loginUsuario(String token) {
		Object[] arrayParams = new Object[] { token };
		Usuario usuario = jdbcTemplate.queryForObject(UsuarioDaoContrato.BUSCAR_USUARIO_TOKEN, arrayParams,
				usuarioRowMapper);
		return usuario;
	}

	@Override
	public void setarAutenticado(Long idUsuario) {
		Object[] arrayParams = new Object[] { idUsuario };
		jdbcTemplate.update(UsuarioDaoContrato.SETAR_AUTENTICADO, arrayParams);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		pessoaDao.updatePessoa(usuario.getPessoa());

	}

	@Override
	public void trocarStatusUsuairo(Usuario usuario) {
		Object[] arrayParams = new Object[] { usuario.isAtivo(), usuario.getIdUsuario() };
		jdbcTemplate.update(UsuarioDaoContrato.TROCAR_STATUS_USUARIO, arrayParams);
	}

	@Override
	public void verificarSenhaAtual(Long idUsuario, String senhaAntiga) {
		jdbcTemplate.queryForObject(UsuarioDaoContrato.VERIFICAR_SENHA, usuarioRowMapper,
				new Object[] { idUsuario, senhaAntiga });
	}

	@Override
	public void trocarSenha(Long idUsuario, String senha) {

		jdbcTemplate.update(UsuarioDaoContrato.TROCAR_SENHA, new Object[] { senha, idUsuario });
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) throws CarrosUserNotFound {
		try {
			return (Usuario) jdbcTemplate.queryForObject(UsuarioDaoContrato.BUSCAR_EMAIL, usuarioRowMapper,
					new Object[] { email });
		} catch (EmptyResultDataAccessException e) {
			throw new CarrosUserNotFound();
		}
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	@Autowired
	public void setPasswordHandler(PasswordHandler passwordHandler) {
		this.passwordHandler = passwordHandler;
	}

	@Autowired
	public void setUsuarioRowMapper(UsuarioRowMapper usuarioRowMapper) {
		this.usuarioRowMapper = usuarioRowMapper;
	}

	@Override
	public void inserirTokenEsqueciSenha(String hash, Long idUsuario) {
		jdbcTemplate.update(UsuarioDaoContrato.INSERIR_TOKEN_ESQUECI_SENHA, new Object[] { hash, idUsuario });
	}

	@Override
	public Usuario verificarTokenEsqueciSenha(String token) throws CarrosUserNotFound {
		try {
		return (Usuario) jdbcTemplate.queryForObject(UsuarioDaoContrato.BUSCAR_USUARIO_POR_TOKEN_ESQUECI_SENHA,
				usuarioRowMapper, new Object[] { token });
		} catch(EmptyResultDataAccessException e) {
			throw new CarrosUserNotFound();
		}
	}
}
