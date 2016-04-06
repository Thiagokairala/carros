package carros.dao.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
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
import carros.services.security.password.PasswordHandler;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private JdbcTemplate jdbcTemplate;
	private PessoaDao pessoaDao;
	private PasswordHandler passwordHandler;
	private UsuarioRowMapper usuarioRowMapper;

	@Override
	public Usuario inserirUsuario(Usuario usuario) {
		Pessoa pessoa = pessoaDao.inserirPessoa(usuario.getPessoa());

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		usuario.setSenha(this.passwordHandler.criptografarSenha(usuario.getSenha()));
		usuario.setTokenAutenticacao(
				passwordHandler.criptografarSenha(usuario.getEmail()) + gregorianCalendar.getTimeInMillis());
		System.out.println(usuario.getTokenAutenticacao());
		
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
}
