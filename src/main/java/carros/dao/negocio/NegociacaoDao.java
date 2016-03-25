package carros.dao.negocio;

import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.Lojista;

public interface NegociacaoDao {

	public void comecarNegociacao(Negociacao negociacao, Lojista lojista, Chat chat);

}
