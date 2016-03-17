package carros.regras.residenciais;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.residenciais.Telefone;

public interface TelefoneRegra {

	public Telefone buildTelefone(ResultSet rs);

	public Telefone buildTelefone(Map<String, Object> row);

}
