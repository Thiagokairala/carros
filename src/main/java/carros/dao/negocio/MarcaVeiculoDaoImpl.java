package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.MarcaVeiculo;
import carros.regras.negocio.MarcaVeiculoRegra;

@Repository
public class MarcaVeiculoDaoImpl implements MarcaVeiculoDao {

	private JdbcTemplate jdbcTemplate;
	private MarcaVeiculoRegra marcaVeiculoRegra;

	@Override
	public List<MarcaVeiculo> listarTodasMarcas() {
		List<MarcaVeiculo> marcasVeiculos = new ArrayList<MarcaVeiculo>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(MarcaVeiculoDaoContrato.SELECT_MARCA_VEICULOS);

		for (Map<String, Object> row : rows) {
			MarcaVeiculo marcaVeiculo = marcaVeiculoRegra.buildMarcaVeiculo(row);

			marcasVeiculos.add(marcaVeiculo);
		}

		return marcasVeiculos;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setMarcaVeiculoRegra(MarcaVeiculoRegra marcaVeiculoRegra) {
		this.marcaVeiculoRegra = marcaVeiculoRegra;
	}

}
