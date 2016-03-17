package carros.regras.negocio;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.negocio.Oferta;
import carros.regras.CarrosRegras;
import carros.regras.pessoa.ConcessionariaRegra;

@Component
public class OfertaRuleImpl extends CarrosRegras implements OfertaRule {

	private ConcessionariaRegra concessionariaRegra;
	private VeiculoRegra veiculoRegra;

	@Override
	public Oferta buildOferta(Map<String, Object> row) {
		Oferta oferta = new Oferta();

		oferta.setId(getLong(row, "idoferta"));
		oferta.setValorDaOferta(getBidDecimal(row, "db_preco_oferta"));
		oferta.setDataCriado(getGregorianCalendar(row, "dt_criado"));
		oferta.setVeiculo(veiculoRegra.buildVeiculo(row));
		oferta.setConcessionaria(concessionariaRegra
				.construirConcessionaria(row));
		return oferta;
	}

	@Autowired
	public void setConcessionariaRegra(ConcessionariaRegra concessionariaRegra) {
		this.concessionariaRegra = concessionariaRegra;
	}

	@Autowired
	public void setVeiculoRegra(VeiculoRegra veiculoRegra) {
		this.veiculoRegra = veiculoRegra;
	}

}
