package carros.entities.usuarios;

import java.io.Serializable;

public class Concessionaria implements Serializable {

	private static final long serialVersionUID = 4383597120730145553L;
	private Long idConcessionaria;
	private String responsavel;

	private int numeroAvaliacoes;
	private double notaGeral;
	
	private Usuario usuario;

	public Long getIdConcessionaria() {
		return idConcessionaria;
	}

	public void setIdConcessionaria(Long idConcessionaria) {
		this.idConcessionaria = idConcessionaria;
	}

	public int getNumeroAvaliacoes() {
		return numeroAvaliacoes;
	}

	public void setNumeroAvaliacoes(int numeroAvaliacoes) {
		this.numeroAvaliacoes = numeroAvaliacoes;
	}

	public double getNotaGeral() {
		return notaGeral;
	}

	public void setNotaGeral(double notaGeral) {
		this.notaGeral = notaGeral;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	

}
