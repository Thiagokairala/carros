package carros.regras.negocio;

import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.comunicacao.Notificacao;
import carros.regras.CarrosRegras;

@Component
public class NotificacaoRegraImpl extends CarrosRegras implements NotificacaoRegra {

	@Override
	public Notificacao buildNotificacao(Map<String, Object> row) {
		Notificacao notificacao = new Notificacao();
		notificacao.setCorpo(getString(row, "txt_corpo"));
		notificacao.setTitulo(getString(row, "txt_titulo"));
		return notificacao;
	}

}
