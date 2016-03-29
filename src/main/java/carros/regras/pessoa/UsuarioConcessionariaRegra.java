package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.usuarios.UsuarioConcessionaria;

public interface UsuarioConcessionariaRegra {
	public UsuarioConcessionaria buildUsuarioConcessionaria(ResultSet rs);

	public UsuarioConcessionaria buildUsuarioConcessionaria(Map<String, Object> row);
}
