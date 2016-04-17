package carros.services.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.CorVeiculoDao;
import carros.entities.negocio.CorVeiculo;

@Service
public class CorVeiculoService {
	private CorVeiculoDao corVeiculoDao;

	public List<CorVeiculo> listaCores() {
		return corVeiculoDao.listarCores();
	}

	@Autowired
	public void setCorVeiculoDao(CorVeiculoDao corVeiculoDao) {
		this.corVeiculoDao = corVeiculoDao;
	}

}
