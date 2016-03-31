package carros.entities.comunicacao;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = -6899954274558146450L;

	private String mensagem;
	private Long idChat;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getIdChat() {
		return idChat;
	}

	public void setIdChat(Long idChat) {
		this.idChat = idChat;
	}

}
