package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.TipoVeiculo;
import carros.regras.negocio.TipoVeiculoRegra;

@Repository
public class TipoVeiculoDaoImpl implements TipoVeiculoDao {

	private JdbcTemplate jdbcTemplate;
	private TipoVeiculoRegra tipoVeiculoRegra;

	@Override
	public List<TipoVeiculo> listarTiposVeiculo() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(TipoVeiculoDaoContrato.LISTAR_TIPO_VEICULO);
		List<TipoVeiculo> tiposVeiculo = new ArrayList<TipoVeiculo>();

		for (Map<String, Object> row : rows) {
			tiposVeiculo.add(tipoVeiculoRegra.buildTipoVeiculo(row));
		}

		return tiposVeiculo;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setTipoVeiculoRegra(TipoVeiculoRegra tipoVeiculoRegra) {
		this.tipoVeiculoRegra = tipoVeiculoRegra;
	}

}
