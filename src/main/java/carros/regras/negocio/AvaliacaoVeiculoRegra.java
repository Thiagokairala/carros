package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.negocio.AvaliacaoVeiculo;

public interface AvaliacaoVeiculoRegra {
	public AvaliacaoVeiculo buildAvaliacaoVeiculo(Map<String, Object> row);

	public AvaliacaoVeiculo buildAvaliacaoVeiculo(ResultSet rs);
}
