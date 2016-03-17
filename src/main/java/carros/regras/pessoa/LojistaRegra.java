package carros.regras.pessoa;

import java.sql.ResultSet;

import carros.entities.usuarios.Lojista;

public interface LojistaRegra {
	public Lojista buildLojista(ResultSet rs);
}
