package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.negocio.Oferta;

public interface OfertaRule {
	public Oferta buildOferta(Map<String, Object> row);

	public Oferta buildOferta(ResultSet rs);
}
