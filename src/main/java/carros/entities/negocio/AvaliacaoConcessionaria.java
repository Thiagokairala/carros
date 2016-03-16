package carros.entities.negocio;

import java.io.Serializable;
import java.util.GregorianCalendar;

import carros.entities.usuarios.Concessionaria;

public class AvaliacaoConcessionaria implements Serializable {

	private static final long serialVersionUID = -8633950309588103472L;
	private Long id;
	private int notaDocumentacao;
	private int notaInformacao;
	private Concessionaria concessionaria;
	private GregorianCalendar dataAvaliacao;
	private int notaVelocidade;
	private double notaGeral;

	public int getNotaDocumentacao() {
		return notaDocumentacao;
	}

	public void setNotaDocumentacao(int notaDocumentacao) {
		this.notaDocumentacao = notaDocumentacao;
	}

	public int getNotaInformacao() {
		return notaInformacao;
	}

	public void setNotaInformacao(int notaInformacao) {
		this.notaInformacao = notaInformacao;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public GregorianCalendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(GregorianCalendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public int getNotaVelocidade() {
		return notaVelocidade;
	}

	public void setNotaVelocidade(int notaVelocidade) {
		this.notaVelocidade = notaVelocidade;
	}

	public double getNotaGeral() {
		return notaGeral;
	}

	public void setNotaGeral(double notaGeral) {
		this.notaGeral = notaGeral;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
