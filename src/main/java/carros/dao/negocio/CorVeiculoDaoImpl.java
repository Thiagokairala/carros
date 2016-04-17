package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.CorVeiculo;
import carros.regras.negocio.CorRegra;

@Repository
public class CorVeiculoDaoImpl implements CorVeiculoDao {
	private JdbcTemplate jdbcTemplate;
	private CorRegra corRegra;

	@Override
	public List<CorVeiculo> listarCores() {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(CorVeiculoDaoContrato.LISTAR_CORES);
		List<CorVeiculo> cores = new ArrayList<CorVeiculo>();
		for(Map<String, Object> row: rows) {
			cores.add(corRegra.buildCor(row));
		}
		return cores;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setCorRegra(CorRegra corRegra) {
		this.corRegra = corRegra;
	}

}
