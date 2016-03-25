package carros.services.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.ChatDao;
import carros.dao.negocio.NegociacaoDao;
import carros.dao.negocio.OfertaDao;
import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.negocio.Oferta;
import carros.entities.usuarios.Lojista;
import carros.exception.CarrosOfertaJaFinalizadaException;

@Service
public class NegociacaoService {
	private OfertaDao ofertaDao;
	private NegociacaoDao negociacaoDao;
	private ChatDao chatDao;

	public void abrirNegociacoes(Negociacao negociacao, Lojista lojista) throws CarrosOfertaJaFinalizadaException {

		Oferta oferta = ofertaDao.buscarOfertaPorId(negociacao.getOferta());

		verificarSeEstaAberto(oferta);

		if (negociacao.getPrecoOferecido().compareTo(oferta.getValorDaOferta()) < 1) {
			abrirNegociacao(negociacao, lojista, oferta);
		} else {
			finalizarOferta(negociacao, oferta, lojista);
		}

	}

	private void finalizarOferta(Negociacao negociacao, Oferta oferta, Lojista lojista) {
		// TODO Auto-generated method stub
		
	}

	private void abrirNegociacao(Negociacao negociacao, Lojista lojista, Oferta oferta) {
		Chat chat = new Chat();
		chat.setLojista(lojista);
		chat.setNomeDoChat("Chat " + lojista.getUsuario().getPessoa().getNomeDeTela() + " - "
				+ oferta.getConcessionaria().getUsuario().getPessoa().getNomeDeTela());
		chat = chatDao.criarChat(chat);
		negociacaoDao.comecarNegociacao(negociacao, lojista, chat);
	}

	private void verificarSeEstaAberto(Oferta oferta) throws CarrosOfertaJaFinalizadaException {
		if (oferta.getFinalizado()) {
			throw new CarrosOfertaJaFinalizadaException("Esta oferta já finalizou");
		}
	}

	@Autowired
	public void setOfertaDao(OfertaDao ofertaDao) {
		this.ofertaDao = ofertaDao;
	}

	@Autowired
	public void setNegociacaoDao(NegociacaoDao negociacaoDao) {
		this.negociacaoDao = negociacaoDao;
	}

	@Autowired
	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

}
