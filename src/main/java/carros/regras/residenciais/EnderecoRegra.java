package carros.regras.residenciais;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.residenciais.Endereco;

public interface EnderecoRegra {
	public Endereco buildEndereco(ResultSet rs);

	public Endereco buildEndereco(Map<String, Object> row);
}
