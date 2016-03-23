package carros.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.Veiculo;

@Repository
public class VeiculoDaoImpl implements VeiculoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Veiculo> buscarTodosVeiculos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo inserirVeiculo(Veiculo veiculo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement stmt = connection.prepareStatement(VeiculoDaoContract.INSERIR_VEICULOS,
						new String[] { "id" });
				stmt.setLong(1, veiculo.getModeloVeiculo().getId());
				stmt.setLong(2, veiculo.getAvaliacaoVeiculo().getId());

				return stmt;
			}
		}, keyHolder);

		veiculo.setId((Long) keyHolder.getKey());
		return veiculo;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
