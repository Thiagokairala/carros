package carros.entities.comunicacao;

import java.io.Serializable;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = -6899954274558146450L;

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
