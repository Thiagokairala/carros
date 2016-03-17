package carros.entities.usuarios;

import java.io.Serializable;

public class UsuarioConcessionaria implements Serializable {

	private static final long serialVersionUID = -4820465643086366525L;

	private Long idUsuarioConcessionaria;
	private Concessionaria concessionaria;
	private NivelUsuarioConcessionaria nivelUsuarioConcessionaria;
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
