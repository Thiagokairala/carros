package carros.entities.residenciais;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 8440432669966141893L;

	private Long id;
	private String cep;
	private String endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
