package carros.services.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.controllers.comunication.ChatSocketController;
import carros.dao.negocio.ChatDao;
import carros.dao.negocio.NegociacaoDao;
import carros.dao.negocio.NotificacaoDao;
import carros.dao.negocio.OfertaDao;
import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.comunicacao.NovaOfertaDto;
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
	private ChatSocketController chatSocketController;

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
			notificacaoDao.criarNotificacao(usuario.getIdUsuarioConcessionaria(), "Negocia��o finalizada",
					gerarCorpoNotificacao(negociacao, oferta, lojista));
		}
		ofertaDao.finalizarOferta(oferta, lojista);
	}

	public void novaOferta(NovaOfertaDto novaOfertaDto) {
		Oferta oferta = ofertaDao.buscarOfertaPorChat(novaOfertaDto);
		Chat chat = chatDao.buscarChat(novaOfertaDto.getChat());
		ofertaDao.finalizarOferta(oferta, chat.getLojista());
		chatDao.finalizarCat(chat);
		chatSocketController.finalizarChat(chat);
	}

	private String gerarCorpoNotificacao(Negociacao negociacao, Oferta oferta, Lojista lojista) {
		String corpoNotificacao = "Negocia��o do carro " + oferta.getVeiculo().getModeloVeiculo().getNome()
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
		List<UsuarioConcessionaria> usuarios = usuarioConcessionariaDao
				.buscarUsuariosDeUmaConcessionaria(oferta.getConcessionaria().getIdConcessionaria());
		chatDao.InserirUsuariosConcessionaria(usuarios, chat.getId());
		chat.setUsuariosConcessionaria(usuarios);
		negociacaoDao.comecarNegociacao(negociacao, lojista, chat);

		return chat;
	}

	private void verificarSeEstaAberto(Oferta oferta) throws CarrosOfertaJaFinalizadaException {
		if (oferta.getFinalizado()) {
			throw new CarrosOfertaJaFinalizadaException("Esta oferta j� finalizou");
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

	@Autowired
	public void setChatSocketController(ChatSocketController chatSocketController) {
		this.chatSocketController = chatSocketController;
	}

}
