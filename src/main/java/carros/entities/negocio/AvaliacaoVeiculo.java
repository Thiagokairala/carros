package carros.entities.negocio;

import java.io.Serializable;
import java.math.BigDecimal;

public class AvaliacaoVeiculo implements Serializable {

	private static final long serialVersionUID = -3485131904550633394L;

	private Long id;
	private String descricao;
	private BigDecimal precoParaConserto;
	private int kmRodado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoParaConserto() {
		return precoParaConserto;
	}

	public void setPrecoParaConserto(BigDecimal precoParaConserto) {
		this.precoParaConserto = precoParaConserto;
	}

	public int getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(int kmRodado) {
		this.kmRodado = kmRodado;
	}

}
