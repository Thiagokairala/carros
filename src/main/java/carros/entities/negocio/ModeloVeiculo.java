package carros.entities.negocio;

import java.io.Serializable;

public class ModeloVeiculo implements Serializable {

	private static final long serialVersionUID = 2596743465114363495L;
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
