package carros.regras.negocio;

import java.sql.ResultSet;
import java.util.Map;

import carros.entities.negocio.CorVeiculo;

public interface CorRegra {

	public CorVeiculo buildCor(Map<String, Object> row);

	public CorVeiculo buildCor(ResultSet rs);

}
