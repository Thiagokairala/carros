package carros.dao.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.pessoa.PessoaDao;
import carros.entities.pessoas.Pessoa;
import carros.entities.usuarios.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private JdbcTemplate jdbcTemplate;
	private PessoaDao pessoaDao;

	@Override
	public Usuario inserirUsuario(Usuario usuario) {
		Pessoa pessoa = pessoaDao.inserirPessoa(usuario);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						UsuarioDaoContrato.INSERIR_USUARIO,
						new String[] { "id" });
				stmt.setString(1, usuario.getUsername());
				stmt.setString(2, usuario.getSenha());
				stmt.setLong(3, pessoa.getId());
				stmt.setString(4, usuario.getEmail());

				return stmt;
			}
		}, keyHolder);

		usuario.setId((Long) keyHolder.getKey());
		return usuario;

	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

}
