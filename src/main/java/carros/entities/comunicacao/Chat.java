package carros.entities.comunicacao;

import java.io.Serializable;
import java.util.List;

import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.UsuarioConcessionaria;

public class Chat implements Serializable {

	private static final long serialVersionUID = 6824067682103558345L;

	private Long id;
	private String nomeDoChat;
	private Boolean finalizado;
	private Lojista lojista;
	private List<UsuarioConcessionaria> usuariosConcessionaria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoChat() {
		return nomeDoChat;
	}

	public void setNomeDoChat(String nomeDoChat) {
		this.nomeDoChat = nomeDoChat;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Lojista getLojista() {
		return lojista;
	}

	public void setLojista(Lojista lojista) {
		this.lojista = lojista;
	}

	public List<UsuarioConcessionaria> getUsuariosConcessionaria() {
		return usuariosConcessionaria;
	}

	public void setUsuariosConcessionaria(
			List<UsuarioConcessionaria> usuariosConcessionaria) {
		this.usuariosConcessionaria = usuariosConcessionaria;
	}
}
