package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.ModeloVeiculoDao;
import carros.entities.negocio.ModeloVeiculo;

@Service
public class ModeloVeiculoService {

	private ModeloVeiculoDao modeloVeiculoDao;

	public String registrar(ModeloVeiculo modeloVeiculo) {
		modeloVeiculoDao.registrar(modeloVeiculo);
		return null;
	}

	@Autowired
	public void setModeloVeiculoDao(ModeloVeiculoDao modeloVeiculoDao) {
		this.modeloVeiculoDao = modeloVeiculoDao;
	}

}
