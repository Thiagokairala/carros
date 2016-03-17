package carros.regras.negocio;

import java.util.Map;

import carros.entities.negocio.Oferta;

public interface OfertaRule {
	public Oferta buildOferta(Map<String, Object> row);
}
