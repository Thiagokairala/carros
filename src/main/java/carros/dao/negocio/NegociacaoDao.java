package carros.dao.negocio;

import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.negocio.Oferta;
import carros.entities.usuarios.Lojista;

public interface NegociacaoDao {

	public void comecarNegociacao(Negociacao negociacao, Lojista lojista, Chat chat);

	public void finalizarOferta(Negociacao negociacao, Oferta oferta, Lojista lojista);

}
