package carros.services.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.TipoVeiculoDao;
import carros.entities.negocio.TipoVeiculo;

@Service
public class TipoVeiculoService {

	private TipoVeiculoDao tipoVeiculoDao;

	public List<TipoVeiculo> listarTiposVeiculo() {

		return tipoVeiculoDao.listarTiposVeiculo();
	}

	@Autowired
	public void setTipoVeiculoDao(TipoVeiculoDao tipoVeiculoDao) {
		this.tipoVeiculoDao = tipoVeiculoDao;
	}

}
