package carros.entities.residenciais;

import java.io.Serializable;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 1160566784123012201L;

	private Long id;
	private String ddd;
	private String numeroDeTelefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumeroDeTelefone() {
		return numeroDeTelefone;
	}

	public void setNumeroDeTelefone(String numeroDeTelefone) {
		this.numeroDeTelefone = numeroDeTelefone;
	}

}
