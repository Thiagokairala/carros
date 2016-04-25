package carros.services.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.ConcessionariaDao;
import carros.entities.usuarios.Concessionaria;
import carros.entities.usuarios.TipoUsuario;

@Service
public class ConcessionariaCrudService {

	private ConcessionariaDao concessionariaDao;

	public Concessionaria inserirConcessionaria(Concessionaria concessionaria) throws Exception {
		concessionaria.getUsuario().setTipoUsuario(new TipoUsuario(new Long(2)));
		return concessionariaDao.inserirConcessionaria(concessionaria);
	}

	public List<Concessionaria> buscarTodasConcessionarias() {
		return concessionariaDao.buscarTodasConcessionaria();

	}

	public void updateConcessionaria(Concessionaria concessionaria) {

		concessionariaDao.update(concessionaria);
	}

	public Concessionaria buscarConcessionariaPorId(long id) {
		return concessionariaDao.buscarConcessionariaPorIdUsuario(id);
	}

	@Autowired
	public void setConcessionariaDao(ConcessionariaDao concessionariaDao) {
		this.concessionariaDao = concessionariaDao;
	}

}
