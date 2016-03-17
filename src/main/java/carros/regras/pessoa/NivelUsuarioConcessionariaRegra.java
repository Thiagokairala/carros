package carros.regras.pessoa;

import java.sql.ResultSet;

import carros.entities.usuarios.NivelUsuarioConcessionaria;

public interface NivelUsuarioConcessionariaRegra {
	public NivelUsuarioConcessionaria buildNivelUsuarioConcessionaria(
			ResultSet rs);
}
