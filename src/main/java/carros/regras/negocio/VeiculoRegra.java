package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.negocio.Veiculo;

public interface VeiculoRegra {
	public Veiculo buildVeiculo(Map<String, Object> row);

	public Veiculo buildVeiculo(ResultSet rs);
}
