package carros.dao.negocio;

import java.util.List;

import carros.entities.negocio.Oferta;

public interface OfertaDao {
	public List<Oferta> buscarTodasOfertas();
}
