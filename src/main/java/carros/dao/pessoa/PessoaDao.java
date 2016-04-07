package carros.dao.pessoa;

import carros.entities.pessoas.Pessoa;

public interface PessoaDao {
	public Pessoa inserirPessoa(Pessoa pessoa);

	public void updatePessoa(Pessoa pessoa);
}
