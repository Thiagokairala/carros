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
import carros.entities.usuarios.Concessionaria;
import carros.entities.usuarios.Usuario;

@Repository
public class ConcessionariaDaoImpl implements ConcessionariaDao {

	private JdbcTemplate jdbcTemplate;
	private UsuarioDao usuarioDao;

	@Override
	public Concessionaria inserirConcessionaria(Concessionaria concessionaria) {
		Usuario usuario = usuarioDao.inserirUsuario(concessionaria);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						ConcessionariaContrato.INSERIR_CONCESSIONARIA,
						new String[] { "id" });
				stmt.setLong(1, usuario.getIdUsuario());
				return stmt;
			}
		}, keyHolder);

		concessionaria.setIdConcessionaria((Long) keyHolder.getKey());

		return concessionaria;
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
