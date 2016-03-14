package carros.entities.negocio;

import java.io.Serializable;

import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.Lojista;

public class OfertaLojista implements Serializable {

	private static final long serialVersionUID = -5588803868504915720L;
	private Lojista lojista;
	private Oferta oferta;
	private Chat chat;

	public Lojista getLojista() {
		return lojista;
	}

	public void setLojista(Lojista lojista) {
		this.lojista = lojista;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}
}
