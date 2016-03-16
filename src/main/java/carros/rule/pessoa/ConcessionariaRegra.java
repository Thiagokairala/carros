package carros.rule.pessoa;

import java.sql.ResultSet;

import carros.entities.usuarios.Concessionaria;

public interface ConcessionariaRegra {
	public Concessionaria construirConcessionaria(ResultSet rs);
}
