package carros.entities.usuarios;

import java.io.Serializable;

public class Lojista extends Usuario implements Serializable {

	private static final long serialVersionUID = 2276299575822593380L;

	private Long idLojista;

	public Long getIdLojista() {
		return idLojista;
	}

	public void setIdLojista(Long idLojista) {
		this.idLojista = idLojista;
	}

}
