package carros.regras.comunicacao;

import java.util.Map;

import carros.entities.comunicacao.Mensagem;

public interface MensagemRegra {

	public Mensagem buildMensagem(Map<String, Object> row);

}
