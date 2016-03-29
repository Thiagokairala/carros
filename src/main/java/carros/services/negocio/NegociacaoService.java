package carros.services.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.negocio.ChatDao;
import carros.dao.negocio.NegociacaoDao;
import carros.dao.negocio.NotificacaoDao;
import carros.dao.negocio.OfertaDao;
import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.negocio.Oferta;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.exception.CarrosOfertaJaFinalizadaException;

@Service
public class NegociacaoService {
	private OfertaDao ofertaDao;
	private NegociacaoDao negociacaoDao;
	private ChatDao chatDao;
	private NotificacaoDao notificacaoDao;
	private UsuarioConcessionariaDao usuarioConcessionariaDao;

	public Chat abrirNegociacoes(Negociacao negociacao, Lojista lojista) throws CarrosOfertaJaFinalizadaException {

		Oferta oferta = ofertaDao.buscarOfertaPorId(negociacao.getOferta());

		verificarSeEstaAberto(oferta);

		if (negociacao.getPrecoOferecido().compareTo(oferta.getValorDaOferta()) < 0) {
			return abrirNegociacao(negociacao, lojista, oferta);
		} else {
			finalizarOferta(negociacao, oferta, lojista);
		}

		return null;
	}

	public void finalizarOferta(Negociacao negociacao, Oferta oferta, Lojista lojista) {
		negociacaoDao.finalizarOferta(negociacao, oferta, lojista);
		List<UsuarioConcessionaria> destinatariosNotificacao = usuarioConcessionariaDao
				.buscarUsuariosDeUmaConcessionaria(oferta.getConcessionaria().getIdConcessionaria());
		for (UsuarioConcessionaria usuario : destinatariosNotificacao) {
			notificacaoDao.criarNotificacao(usuario.getIdUsuarioConcessionaria(), "Negociação finalizada",
					gerarCorpoNotificacao(negociacao, oferta, lojista));
		}
		ofertaDao.finalizarOferta(oferta, lojista);
	}

	private String gerarCorpoNotificacao(Negociacao negociacao, Oferta oferta, Lojista lojista) {
		String corpoNotificacao = "Negociação do carro " + oferta.getVeiculo().getModeloVeiculo().getNome()
				+ " cotada por: " + oferta.getValorDaOferta() + " finalizada e fechada com o lojista: "
				+ lojista.getUsuario().getPessoa().getNomeDeTela() + " por: " + negociacao.getPrecoOferecido();
		return corpoNotificacao;
	}

	private Chat abrirNegociacao(Negociacao negociacao, Lojista lojista, Oferta oferta) {
		Chat chat = new Chat();
		chat.setLojista(lojista);
		chat.setNomeDoChat("Chat " + lojista.getUsuario().getPessoa().getNomeDeTela() + " - "
				+ oferta.getConcessionaria().getUsuario().getPessoa().getNomeDeTela());
		chat = chatDao.criarChat(chat);
		negociacaoDao.comecarNegociacao(negociacao, lojista, chat);
		return chat;
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

	@Autowired
	public void setNotificacaoDao(NotificacaoDao notificacaoDao) {
		this.notificacaoDao = notificacaoDao;
	}

	@Autowired
	public void setUsuarioConcessionariaDao(UsuarioConcessionariaDao usuarioConcessionariaDao) {
		this.usuarioConcessionariaDao = usuarioConcessionariaDao;
	}

}
