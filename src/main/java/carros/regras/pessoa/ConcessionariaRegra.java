package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.usuarios.Concessionaria;

public interface ConcessionariaRegra {
	public Concessionaria construirConcessionaria(ResultSet rs);

	public Concessionaria construirConcessionaria(Map<String, Object> row);
}
