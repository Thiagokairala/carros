package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.AvaliacaoVeiculoDao;
import carros.entities.negocio.AvaliacaoVeiculo;

@Service
public class AvaliacaoVeiculoCrudService {

	private AvaliacaoVeiculoDao avaliacaoVeiculoDao;

	public AvaliacaoVeiculo inserirAvaliacaoVeiculo(
			AvaliacaoVeiculo avaliacaoVeiculo) {
		return avaliacaoVeiculoDao.inserir(avaliacaoVeiculo);
	}

	@Autowired
	public void setAvaliacaoVeiculoDao(AvaliacaoVeiculoDao avaliacaoVeiculoDao) {
		this.avaliacaoVeiculoDao = avaliacaoVeiculoDao;
	}

}
