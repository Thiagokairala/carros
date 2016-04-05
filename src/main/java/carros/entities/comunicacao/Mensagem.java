package carros.entities.comunicacao;

import java.io.Serializable;
import java.util.GregorianCalendar;

import carros.entities.pessoas.aparencia.Imagem;

public class Mensagem implements Serializable {

	private static final long serialVersionUID = -6899954274558146450L;

	private Long id;
	private String mensagem;
	private String nomeRemetente;
	private Imagem imagem;
	private GregorianCalendar dataEnvio;
	private Long idUsuario;
	private Chat chat;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public GregorianCalendar getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(GregorianCalendar dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
