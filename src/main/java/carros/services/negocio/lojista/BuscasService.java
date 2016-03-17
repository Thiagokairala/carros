package carros.services.negocio.lojista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.OfertaDao;
import carros.dao.negocio.VeiculoDao;
import carros.entities.negocio.Veiculo;

@Service
public class BuscasService {

	private OfertaDao ofertaDao;

	public List<Veiculo> listarTodasOfertas() {
		return ofertaDao.buscarTodasOfertas();
	}

	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}
}
