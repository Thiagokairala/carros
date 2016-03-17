package carros.regras.pessoa;

import java.sql.ResultSet;

import carros.entities.usuarios.UsuarioConcessionaria;

public interface UsuarioConcessionariaRegra {
	public UsuarioConcessionaria buildUsuarioConcessionaria(ResultSet rs);
}
