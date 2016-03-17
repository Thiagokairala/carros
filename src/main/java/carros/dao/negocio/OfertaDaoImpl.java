package carros.dao.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import carros.entities.negocio.Oferta;
import carros.regras.negocio.OfertaRule;

@Repository
public class OfertaDaoImpl implements OfertaDao {

	private OfertaRule ofertaRule;

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Oferta> buscarTodasOfertas() {
		List<Oferta> ofertas = new ArrayList<Oferta>();

		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList(OfertaDaoContrato.SELECT_TODAS_OFERTAS);
		for (Map<String, Object> row : rows) {
			ofertas.add(ofertaRule.buildOferta(row));
		}
		return ofertas;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setOfertaRule(OfertaRule ofertaRule) {
		this.ofertaRule = ofertaRule;
	}

}
