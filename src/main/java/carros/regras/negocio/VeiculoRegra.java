package carros.regras.negocio;

import java.util.Map;

import carros.entities.negocio.Veiculo;

public interface VeiculoRegra {
	public Veiculo buildVeiculo(Map<String, Object> row);
}
