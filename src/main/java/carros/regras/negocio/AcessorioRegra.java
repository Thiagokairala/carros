package carros.regras.negocio;

import java.util.Map;

import carros.entities.negocio.Acessorio;

public interface AcessorioRegra {

	public Acessorio buildAcessorio(Map<String, Object> row);

}
