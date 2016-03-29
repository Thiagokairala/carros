package carros.services.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.AcessoriosDao;
import carros.entities.negocio.Acessorio;
import carros.entities.negocio.Veiculo;

@Service
public class AcessoriosService {

	private AcessoriosDao acessoriosDao;

	public List<Acessorio> getAcessorios(Long id) {

		return acessoriosDao.buscarAcessoriosOferta(id);
	}

	public List<Acessorio> getAcessorios() {
		return acessoriosDao.buscarAcessorios();
	}

	@Autowired
	public void setAcessoriosDao(AcessoriosDao acessoriosDao) {
		this.acessoriosDao = acessoriosDao;
	}

	public void inserirAcessoriosVeiculo(Veiculo veiculo) {
		for (Acessorio acessorio : veiculo.getAcessorios()) {
			acessoriosDao.inserirAcessorioVeiculo(acessorio, veiculo.getId());
		}
	}

}
