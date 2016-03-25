package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.negocio.MarcaVeiculo;

public interface MarcaVeiculoRegra {
	public MarcaVeiculo buildMarcaVeiculo(Map<String, Object> row);

	public MarcaVeiculo buildMarcaVeiculo(ResultSet rs);
}
