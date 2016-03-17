package carros.regras.residenciais;

import java.sql.ResultSet;

import carros.entities.residenciais.Telefone;

public interface TelefoneRegra {

	public Telefone buildTelefone(ResultSet rs);

}
