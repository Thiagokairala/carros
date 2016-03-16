package carros.dao.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.dao.security.UsuarioDao;
import carros.entities.usuarios.Usuario;
import carros.entities.usuarios.UsuarioConcessionaria;

@Repository
public class UsuarioConcessionariaDaoImpl implements UsuarioConcessionariaDao {
	private JdbcTemplate jdbcTemplate;
	private UsuarioDao usuarioDao;

	@Override
	public UsuarioConcessionaria inserirUsuarioConcessionaria(
			UsuarioConcessionaria usuarioConcessionaria) {
		Usuario usuario = usuarioDao.inserirUsuario(usuarioConcessionaria);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection
						.prepareStatement(
								UsuarioConcessionariaDaoContrato.INSERIR_USUARIO_CONCESSIONARIA,
								new String[] { "id" });
				stmt.setLong(1, usuarioConcessionaria.getConcessionaria()
						.getIdConcessionaria());
				stmt.setLong(2, usuario.getIdUsuario());
				stmt.setLong(3, usuarioConcessionaria
						.getNivelUsuarioConcessionaria().getId());

				return stmt;
			}
		}, keyHolder);

		usuarioConcessionaria.setIdUsuarioConcessionaria((Long) keyHolder
				.getKey());
		return usuarioConcessionaria;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
