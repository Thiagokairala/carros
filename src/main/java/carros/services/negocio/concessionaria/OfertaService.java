package carros.services.negocio.concessionaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.MarcaVeiculoDao;
import carros.dao.negocio.ModeloVeiculoDao;
import carros.entities.negocio.MarcaVeiculo;
import carros.entities.negocio.ModeloVeiculo;
import carros.entities.negocio.Oferta;

@Service
public class OfertaService {
	private MarcaVeiculoDao marcaVeiculoDao;
	private ModeloVeiculoDao modeloVeiculoDao;

	public List<MarcaVeiculo> getTodasMarcas() {

		return marcaVeiculoDao.listarTodasMarcas();
	}

	public List<ModeloVeiculo> getModelosPorMarca(int idMarca) {

		return modeloVeiculoDao.listarModelosPorMarca(idMarca);
	}

	public Oferta cadastrarOferta(Oferta oferta) {
		
		return null;
	}

	@Autowired
	public void setMarcaVeiculoDao(MarcaVeiculoDao marcaVeiculoDao) {
		this.marcaVeiculoDao = marcaVeiculoDao;
	}

	@Autowired
	public void setModeloVeiculoDao(ModeloVeiculoDao modeloVeiculoDao) {
		this.modeloVeiculoDao = modeloVeiculoDao;
	}

}
