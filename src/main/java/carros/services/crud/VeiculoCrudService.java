package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.VeiculoDao;
import carros.entities.negocio.AvaliacaoVeiculo;
import carros.entities.negocio.Veiculo;

@Service
public class VeiculoCrudService {

	private VeiculoDao veiculoDao;
	private AvaliacaoVeiculoCrudService avaliacaoVeiculoCrudService;

	public Veiculo inserirVeiculo(Veiculo veiculo) {
		AvaliacaoVeiculo avaliacaoVeiculo = avaliacaoVeiculoCrudService
				.inserirAvaliacaoVeiculo(veiculo.getAvaliacaoVeiculo());
		veiculo.setAvaliacaoVeiculo(avaliacaoVeiculo);
		return veiculoDao.inserirVeiculo(veiculo);
	}

	@Autowired
	public void setVeiculoDao(VeiculoDao veiculoDao) {
		this.veiculoDao = veiculoDao;
	}

	@Autowired
	public void setAvaliacaoVeiculoCrudService(AvaliacaoVeiculoCrudService avaliacaoVeiculoCrudService) {
		this.avaliacaoVeiculoCrudService = avaliacaoVeiculoCrudService;
	}

}
