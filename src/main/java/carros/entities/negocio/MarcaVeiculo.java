package carros.entities.negocio;

import java.io.Serializable;

public class MarcaVeiculo implements Serializable {

	private static final long serialVersionUID = 3545889579865371011L;
	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
