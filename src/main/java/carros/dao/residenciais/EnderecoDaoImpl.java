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

import carros.entities.residenciais.Endereco;

@Repository
public class EnderecoDaoImpl implements EnderecoDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public Endereco inserir(Endereco endereco) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						EnderecoDaoContrato.INSERIR_ENDERECO,
						new String[] { "id" });
				stmt.setString(1, endereco.getCep());
				stmt.setString(2, endereco.getEndereco());
				return stmt;
			}
		}, keyHolder);

		endereco.setId((Long) keyHolder.getKey());

		return endereco;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
