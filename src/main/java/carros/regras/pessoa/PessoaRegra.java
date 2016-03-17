package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.pessoas.Pessoa;

public interface PessoaRegra {
	public Pessoa buildPessoa(ResultSet rs);

	public Pessoa buildPessoa(Map<String, Object> row);
}
