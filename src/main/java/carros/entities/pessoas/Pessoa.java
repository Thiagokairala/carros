package carros.entities.pessoas;

import java.io.Serializable;
import java.util.GregorianCalendar;

import carros.entities.pessoas.aparencia.Imagem;
import carros.entities.residenciais.Endereco;
import carros.entities.residenciais.Telefone;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = -3427039606783231089L;

	private long idPessoa;
	private String docIdentificacao;
	private String nome;
	private String nomeDeTela;
	private GregorianCalendar dataCriacao;
	private Telefone telefone;
	private Endereco endereco;
	private Imagem imagem;

	public long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(long id) {
		this.idPessoa = id;
	}

	public String getDocIdentificacao() {
		return docIdentificacao;
	}

	public void setDocIdentificacao(String docIdentificacao) {
		this.docIdentificacao = docIdentificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeDeTela() {
		return nomeDeTela;
	}

	public void setNomeDeTela(String nomeDeTela) {
		this.nomeDeTela = nomeDeTela;
	}

	public GregorianCalendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

}
