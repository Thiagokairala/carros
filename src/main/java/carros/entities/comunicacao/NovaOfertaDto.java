package carros.entities.comunicacao;

import java.io.Serializable;
import java.math.BigDecimal;

public class NovaOfertaDto implements Serializable {

	private static final long serialVersionUID = 5718107324126528535L;
	private BigDecimal valorOferta;
	private Chat chat;

	public BigDecimal getValorOferta() {
		return valorOferta;
	}

	public void setValorOferta(BigDecimal valorOferta) {
		this.valorOferta = valorOferta;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

}
