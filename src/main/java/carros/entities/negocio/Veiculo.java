package carros.entities.negocio;

import java.io.Serializable;
import java.util.List;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 8601130510978860379L;
	private Long id;
	private ModeloVeiculo modeloVeiculo;
	private List<Acessorio> acessorios;
	private AvaliacaoVeiculo avaliacaoVeiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModeloVeiculo getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public AvaliacaoVeiculo getAvaliacaoVeiculo() {
		return avaliacaoVeiculo;
	}

	public void setAvaliacaoVeiculo(AvaliacaoVeiculo avaliacaoVeiculo) {
		this.avaliacaoVeiculo = avaliacaoVeiculo;
	}
}
