package carros.entities.usuarios;

import java.io.Serializable;

public class NivelUsuarioConcessionaria implements Serializable {

	private static final long serialVersionUID = 1377775766257105583L;
	private Long id;
	private String nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
