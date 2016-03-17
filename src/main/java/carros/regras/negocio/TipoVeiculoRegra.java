package carros.regras.negocio;

import java.util.Map;

import carros.entities.negocio.TipoVeiculo;

public interface TipoVeiculoRegra {
	public TipoVeiculo buildTipoVeiculo(Map<String, Object> row);
}
