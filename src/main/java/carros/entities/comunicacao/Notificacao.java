package carros.entities.comunicacao;

import java.io.Serializable;

public class Notificacao implements Serializable {

	private static final long serialVersionUID = 7577021670668972717L;
	private Long id;
	private String titulo;
	private String corpo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

}
