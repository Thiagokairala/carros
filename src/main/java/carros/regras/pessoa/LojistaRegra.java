package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.usuarios.Lojista;

public interface LojistaRegra {
	public Lojista buildLojista(ResultSet rs);

	public Lojista buildLojista(Map<String, Object> row);
}
