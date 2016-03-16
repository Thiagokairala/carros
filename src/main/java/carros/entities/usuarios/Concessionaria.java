package carros.entities.usuarios;

import java.io.Serializable;

public class Concessionaria extends Usuario implements Serializable {

	private static final long serialVersionUID = 4383597120730145553L;
	private Long idConcessionaria;

	private int numeroAvaliacoes;
	private double notaGeral;

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

}
