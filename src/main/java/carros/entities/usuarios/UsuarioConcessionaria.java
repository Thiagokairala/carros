package carros.entities.usuarios;

import java.io.Serializable;

public class UsuarioConcessionaria extends Usuario implements Serializable {

	private static final long serialVersionUID = -4820465643086366525L;

	private Long idUsuarioConcessionaria;
	private Concessionaria concessionaria;
	private NivelUsuarioConcessionaria nivelUsuarioConcessionaria;

	public Long getIdUsuarioConcessionaria() {
		return idUsuarioConcessionaria;
	}

	public void setIdUsuarioConcessionaria(Long idUsuarioConcessionaria) {
		this.idUsuarioConcessionaria = idUsuarioConcessionaria;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public NivelUsuarioConcessionaria getNivelUsuarioConcessionaria() {
		return nivelUsuarioConcessionaria;
	}

	public void setNivelUsuarioConcessionaria(
			NivelUsuarioConcessionaria nivelUsuarioConcessionaria) {
		this.nivelUsuarioConcessionaria = nivelUsuarioConcessionaria;
	}

}
