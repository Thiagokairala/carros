package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.PessoaDao;
import carros.entities.pessoas.Pessoa;

@Service
public class PessoaCrudService {

	PessoaDao pessoaDao;

	public Pessoa inserirPessoa(Pessoa pessoa) {
		return pessoaDao.inserirPessoa(pessoa);
	}

	@Autowired
	public void setPessoaDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}
}
