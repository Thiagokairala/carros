package carros.entities.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import carros.entities.usuarios.Concessionaria;
import carros.entities.usuarios.Lojista;

public class Oferta implements Serializable {

	private static final long serialVersionUID = 2462967432930648430L;

	private Long id;
	private Boolean finalizado;
	private BigDecimal valorDaOferta;
	private Lojista lojistaQueFinalizaou;
	private GregorianCalendar dataCriado;
	private GregorianCalendar dataFinalizacao;
	private Concessionaria concessionaria;
	private Veiculo veiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public BigDecimal getValorDaOferta() {
		return valorDaOferta;
	}

	public void setValorDaOferta(BigDecimal valorDaOferta) {
		this.valorDaOferta = valorDaOferta;
	}

	public Lojista getLojistaQueFinalizaou() {
		return lojistaQueFinalizaou;
	}

	public void setLojistaQueFinalizaou(Lojista lojistaQueFinalizaou) {
		this.lojistaQueFinalizaou = lojistaQueFinalizaou;
	}

	public GregorianCalendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(GregorianCalendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public GregorianCalendar getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(GregorianCalendar dataCriado) {
		this.dataCriado = dataCriado;
	}

}
