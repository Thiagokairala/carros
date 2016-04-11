package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.ModeloVeiculo;
import carros.regras.negocio.ModeloVeiculoRegra;

@Repository
public class ModeloVeiculoDaoImpl implements ModeloVeiculoDao {

	private JdbcTemplate jdbcTemplate;
	private ModeloVeiculoRegra modeloVeiculoRegra;

	@Override
	public List<ModeloVeiculo> listarModelosPorMarca(int idMarca) {
		Object[] paramsArray = new Object[] { idMarca };
		List<ModeloVeiculo> modelosVeiculo = new ArrayList<ModeloVeiculo>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(ModeloVeiculoDaoContrato.SELECT_MODELOS_POR_MARCA,
				paramsArray);

		for (Map<String, Object> row : rows) {
			ModeloVeiculo modeloVeiculo = modeloVeiculoRegra.buildModeloVeiculo(row);

			modelosVeiculo.add(modeloVeiculo);
		}

		return modelosVeiculo;

	}

	@Override
	public void registrar(ModeloVeiculo modeloVeiculo) {
		Object[] arrayParams = new Object[] { modeloVeiculo.getNome(), modeloVeiculo.getMarcaVeiculo().getId(),
				modeloVeiculo.getTipoVeiculo().getId() };
		jdbcTemplate.update(ModeloVeiculoDaoContrato.INSERIR_MODELO_VEICULO, arrayParams);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setModeloVeiculoRegra(ModeloVeiculoRegra modeloVeiculoRegra) {
		this.modeloVeiculoRegra = modeloVeiculoRegra;
	}

}
