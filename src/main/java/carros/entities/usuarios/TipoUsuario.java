package carros.entities.usuarios;

import java.io.Serializable;

public class TipoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricaoTipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

}
