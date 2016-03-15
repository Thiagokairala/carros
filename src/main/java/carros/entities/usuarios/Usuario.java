package carros.entities.usuarios;

import java.io.Serializable;

import carros.entities.pessoas.Pessoa;

public class Usuario extends Pessoa implements Serializable {

	private static final long serialVersionUID = -4077434045093904737L;

	private Long idUsuario;
	private String email;
	private String username;
	private String senha;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
