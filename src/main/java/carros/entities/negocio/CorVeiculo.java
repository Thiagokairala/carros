package carros.entities.negocio;

import java.io.Serializable;

public class CorVeiculo implements Serializable {

	private static final long serialVersionUID = 7575948437645126102L;
	private Long idCor;
	private String cor;

	public Long getIdCor() {
		return idCor;
	}

	public void setIdCor(Long idCor) {
		this.idCor = idCor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
