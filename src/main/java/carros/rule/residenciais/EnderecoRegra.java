package carros.rule.residenciais;

import java.sql.ResultSet;

import carros.entities.residenciais.Endereco;

public interface EnderecoRegra {
	public Endereco buildEndereco(ResultSet rs);
}
