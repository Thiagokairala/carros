package carros.regras.negocio;

import java.util.Map;

import carros.entities.comunicacao.Notificacao;

public interface NotificacaoRegra {

	public Notificacao buildNotificacao(Map<String, Object> row);

}
