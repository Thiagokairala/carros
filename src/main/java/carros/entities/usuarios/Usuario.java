package carros.entities.usuarios;

import java.io.Serializable;

import carros.entities.pessoas.Pessoa;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -4077434045093904737L;

	private Long idUsuario;
	private String email;
	private String username;
	private String senha;
	private TipoUsuario tipoUsuario;
	private String tokenAutenticacao;
	private boolean autenticado;
	private boolean ativo;

	private Pessoa pessoa;

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTokenAutenticacao() {
		return tokenAutenticacao;
	}

	public void setTokenAutenticacao(String tokenAutenticacao) {
		this.tokenAutenticacao = tokenAutenticacao;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
