package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.residenciais.TelefoneDao;
import carros.entities.residenciais.Telefone;

@Service
public class TelefoneCrudService {

	private TelefoneDao telefoneDao;

	public Telefone inserirTelefone(Telefone telefone) {
		return telefoneDao.inserir(telefone);
	}

	@Autowired
	public void setTelefoneDao(TelefoneDao telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

}
