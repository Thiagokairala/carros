package carros.entities.usuarios;

import java.io.Serializable;

public class Lojista implements Serializable {

	private static final long serialVersionUID = 2276299575822593380L;

	private Long idLojista;

	private Usuario usuario;

	public Long getIdLojista() {
		return idLojista;
	}

	public void setIdLojista(Long idLojista) {
		this.idLojista = idLojista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
