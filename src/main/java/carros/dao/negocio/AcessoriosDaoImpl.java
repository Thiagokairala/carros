package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.Acessorio;
import carros.regras.negocio.AcessorioRegra;

@Repository
public class AcessoriosDaoImpl implements AcessoriosDao {

	private JdbcTemplate jdbcTemplate;
	private AcessorioRegra acessorioRegra;

	@Override
	public List<Acessorio> buscarAcessoriosOferta(Long id) {
		Object[] arrayParams = new Object[] { id };
		List<Acessorio> acessoriosList = new ArrayList<Acessorio>();

		List<Map<String, Object>> returnedList = jdbcTemplate
				.queryForList(AcessorioDaoContrato.SELECT_ACESSORIOS_OFERTA, arrayParams);

		for (Map<String, Object> row : returnedList) {
			acessoriosList.add(acessorioRegra.buildAcessorio(row));
		}

		return acessoriosList;
	}

	@Override
	public List<Acessorio> buscarAcessorios() {
		List<Acessorio> acessoriosList = new ArrayList<Acessorio>();

		List<Map<String, Object>> returnedList = jdbcTemplate.queryForList(AcessorioDaoContrato.SELECT_ACESSORIOS);
		for (Map<String, Object> row : returnedList) {
			acessoriosList.add(acessorioRegra.buildAcessorio(row));
		}

		return acessoriosList;
	}

	@Override
	public void inserirAcessorioVeiculo(Acessorio acessorio, Long idVeiculo) {
		if (acessorio.getEstaPresente() == null) {
			acessorio.setEstaPresente(false);
		}
		Object[] arrayParams = new Object[] { idVeiculo, acessorio.getId(), acessorio.getEstaPresente() };

		jdbcTemplate.update(AcessorioDaoContrato.INSERIR_ACESSORIO_VEICULO, arrayParams);

	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setAcessorioRegra(AcessorioRegra acessorioRegra) {
		this.acessorioRegra = acessorioRegra;
	}

}
