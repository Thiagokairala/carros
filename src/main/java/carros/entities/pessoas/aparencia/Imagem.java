package carros.entities.pessoas.aparencia;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Imagem implements Serializable {

	private static final long serialVersionUID = -1142561629070321987L;

	private Long id;
	private String caminhoImagem;
	private String hashImagem;
	private GregorianCalendar dataInclusao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}

	public String getHashImagem() {
		return hashImagem;
	}

	public void setHashImagem(String hashImagem) {
		this.hashImagem = hashImagem;
	}

	public GregorianCalendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(GregorianCalendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
