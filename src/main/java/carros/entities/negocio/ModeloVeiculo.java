package carros.entities.negocio;

import java.io.Serializable;

public class ModeloVeiculo implements Serializable {

	private static final long serialVersionUID = 2596743465114363495L;
	private Long id;
	private String nome;
	private TipoVeiculo tipoVeiculo;
	private MarcaVeiculo marcaVeiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public MarcaVeiculo getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(MarcaVeiculo marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

}
