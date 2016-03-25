package carros.entities.auxiliar;

import java.io.Serializable;
import java.math.BigDecimal;

import carros.entities.negocio.Oferta;

public class Negociacao implements Serializable {

	private static final long serialVersionUID = 1055624494007778846L;
	private BigDecimal precoOferecido;
	private Oferta oferta;

	public BigDecimal getPrecoOferecido() {
		return precoOferecido;
	}

	public void setPrecoOferecido(BigDecimal precoOferecido) {
		this.precoOferecido = precoOferecido;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

}
