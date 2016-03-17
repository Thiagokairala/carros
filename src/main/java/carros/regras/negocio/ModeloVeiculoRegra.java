package carros.regras.negocio;

import java.util.Map;

import carros.entities.negocio.ModeloVeiculo;

public interface ModeloVeiculoRegra {
	public ModeloVeiculo buildModeloVeiculo(Map<String, Object> row);
}
