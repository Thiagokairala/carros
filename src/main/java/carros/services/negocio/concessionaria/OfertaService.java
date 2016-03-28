package carros.services.negocio.concessionaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.MarcaVeiculoDao;
import carros.dao.negocio.ModeloVeiculoDao;
import carros.dao.negocio.OfertaDao;
import carros.entities.negocio.MarcaVeiculo;
import carros.entities.negocio.ModeloVeiculo;
import carros.entities.negocio.Oferta;
import carros.entities.negocio.Veiculo;
import carros.services.crud.VeiculoCrudService;

@Service
public class OfertaService {
	private MarcaVeiculoDao marcaVeiculoDao;
	private ModeloVeiculoDao modeloVeiculoDao;
	private VeiculoCrudService veiculoCrudService;
	private OfertaDao ofertaDao;

	public List<MarcaVeiculo> getTodasMarcas() {

		return marcaVeiculoDao.listarTodasMarcas();
	}

	public List<ModeloVeiculo> getModelosPorMarca(int idMarca) {

		return modeloVeiculoDao.listarModelosPorMarca(idMarca);
	}

	public Oferta cadastrarOferta(Oferta oferta) {
		Veiculo veiculo = veiculoCrudService.inserirVeiculo(oferta.getVeiculo());

		oferta.setVeiculo(veiculo);
		return ofertaDao.inserirOferta(oferta);
	}

	@Autowired
	public void setMarcaVeiculoDao(MarcaVeiculoDao marcaVeiculoDao) {
		this.marcaVeiculoDao = marcaVeiculoDao;
	}

	@Autowired
	public void setModeloVeiculoDao(ModeloVeiculoDao modeloVeiculoDao) {
		this.modeloVeiculoDao = modeloVeiculoDao;
	}

	@Autowired
	public void setVeiculoCrudService(VeiculoCrudService veiculoCrudService) {
		this.veiculoCrudService = veiculoCrudService;
	}

	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}

	
}
