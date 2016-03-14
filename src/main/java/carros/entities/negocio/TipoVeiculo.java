package carros.entities.negocio;

import java.io.Serializable;

public class TipoVeiculo implements Serializable {

	private static final long serialVersionUID = -4764245375060499355L;
	private Long id;
	private String nomeDoTipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoTipo() {
		return nomeDoTipo;
	}

	public void setNomeDoTipo(String nomeDoTipo) {
		this.nomeDoTipo = nomeDoTipo;
	}

}
