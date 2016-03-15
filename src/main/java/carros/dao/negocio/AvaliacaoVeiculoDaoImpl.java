package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.AvaliacaoVeiculo;

@Repository
public class AvaliacaoVeiculoDaoImpl implements AvaliacaoVeiculoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public AvaliacaoVeiculo inserir(AvaliacaoVeiculo avaliacaoVeiculo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(
						AvaliacaoVeiculoDaoContract.INSERIR_AVALIACAO_VEICULO,
						new String[] { "id" });
				stmt.setString(1, avaliacaoVeiculo.getDescricao());
				stmt.setBigDecimal(2, avaliacaoVeiculo.getPrecoParaConserto());
				return stmt;
			}
		}, keyHolder);

		avaliacaoVeiculo.setId((Long) keyHolder.getKey());
		return avaliacaoVeiculo;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
