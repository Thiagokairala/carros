package carros.dao.residenciais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.entities.residenciais.Telefone;

@Repository
public class TelefoneDaoImpl implements TelefoneDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public Telefone inserir(Telefone telefone) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						TelefoneDaoContrato.INSERIR_TELEFONE,
						new String[] { "id" });
				stmt.setString(1, telefone.getDdd());
				stmt.setString(2, telefone.getNumeroDeTelefone());
				return stmt;
			}
		}, keyHolder);

		telefone.setId((Long) keyHolder.getKey());

		return telefone;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
