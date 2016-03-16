package carros.rule.pessoa;

import java.sql.ResultSet;

import carros.entities.pessoas.Pessoa;

public interface PessoaRegra {
	public Pessoa buildPessoa(ResultSet rs);
}
