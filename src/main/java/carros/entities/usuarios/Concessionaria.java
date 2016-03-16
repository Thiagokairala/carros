package carros.entities.usuarios;

import java.io.Serializable;

public class Concessionaria extends Usuario implements Serializable {

	private static final long serialVersionUID = 4383597120730145553L;
	private Long idConcessionaria;

	public Long getIdConcessionaria() {
		return idConcessionaria;
	}

	public void setIdConcessionaria(Long idConcessionaria) {
		this.idConcessionaria = idConcessionaria;
	}

}
