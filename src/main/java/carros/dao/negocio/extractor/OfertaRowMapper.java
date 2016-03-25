package carros.dao.negocio.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import carros.entities.negocio.Oferta;
import carros.regras.negocio.OfertaRule;

@Service
public class OfertaRowMapper implements RowMapper<Oferta> {

	OfertaRule ofertaRule;

	@Override
	public Oferta mapRow(ResultSet rs, int rowNum) throws SQLException {
		return ofertaRule.buildOferta(rs);
	}

	@Autowired
	public void setOfertaRule(OfertaRule ofertaRule) {
		this.ofertaRule = ofertaRule;
	}

}
