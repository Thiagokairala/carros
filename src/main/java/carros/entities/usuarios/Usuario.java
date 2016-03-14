package carros.entities.usuarios;

import java.io.Serializable;

import carros.entities.pessoas.Pessoa;

public abstract class Usuario extends Pessoa implements Serializable {

	private static final long serialVersionUID = -4077434045093904737L;

	private Long idUsuario;
	private String email;
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
