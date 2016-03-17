package carros.dao.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import carros.entities.negocio.Veiculo;

public class VeiculoDaoImpl implements VeiculoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Veiculo> buscarTodosVeiculos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
