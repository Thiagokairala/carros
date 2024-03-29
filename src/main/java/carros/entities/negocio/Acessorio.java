package carros.entities.negocio;

import java.io.Serializable;

public class Acessorio implements Serializable {

	private static final long serialVersionUID = 9115807854030666474L;
	private Long id;
	private String nomeAcessorio;
	private Boolean estaPresente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAcessorio() {
		return nomeAcessorio;
	}

	public void setNomeAcessorio(String nomeAcessorio) {
		this.nomeAcessorio = nomeAcessorio;
	}

	public Boolean getEstaPresente() {
		return estaPresente;
	}

	public void setEstaPresente(Boolean estaPresente) {
		this.estaPresente = estaPresente;
	}
}
