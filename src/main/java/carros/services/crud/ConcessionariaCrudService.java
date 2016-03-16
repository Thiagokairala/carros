package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.ConcessionariaDao;
import carros.entities.usuarios.Concessionaria;

@Service
public class ConcessionariaCrudService {

	private ConcessionariaDao concessionariaDao;

	public Concessionaria inserirConcessionaria(Concessionaria concessionaria) {
		return concessionariaDao.inserirConcessionaria(concessionaria);
	}

	@Autowired
	public void setConcessionariaDao(ConcessionariaDao concessionariaDao) {
		this.concessionariaDao = concessionariaDao;
	}

}
