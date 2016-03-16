package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.LojistaDao;
import carros.entities.usuarios.Lojista;

@Service
public class LojistaCrudService {
	private LojistaDao lojistaDao;

	public Lojista inserirLojista(Lojista lojista) {
		return lojistaDao.inserirLojista(lojista);
	}

	@Autowired
	public void setLojistaDao(LojistaDao lojistaDao) {
		this.lojistaDao = lojistaDao;
	}

}
