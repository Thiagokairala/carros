package carros.regras.comunicacao;

import java.util.Map;

import carros.entities.comunicacao.Chat;

public interface ChatRegra {

	public Chat buildRegra(Map<String, Object> row);

}
