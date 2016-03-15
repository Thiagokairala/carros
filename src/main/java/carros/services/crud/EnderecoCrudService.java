package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.residenciais.EnderecoDao;
import carros.entities.residenciais.Endereco;

@Service
public class EnderecoCrudService {

	private EnderecoDao enderecoDao;

	public Endereco cadastrarEndereco(Endereco endereco) {
		return enderecoDao.inserir(endereco);
	}

	@Autowired
	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

}
