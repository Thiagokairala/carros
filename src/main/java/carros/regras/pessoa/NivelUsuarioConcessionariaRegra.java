package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.usuarios.NivelUsuarioConcessionaria;

public interface NivelUsuarioConcessionariaRegra {
	public NivelUsuarioConcessionaria buildNivelUsuarioConcessionaria(
			ResultSet rs);

	public NivelUsuarioConcessionaria buildNivelUsuarioConcessionaria(Map<String, Object> row);
}
