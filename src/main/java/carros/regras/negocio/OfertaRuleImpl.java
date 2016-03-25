package carros.regras.negocio;

import java.sql.ResultSet;
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
		oferta.setFinalizado(getBoolean(row, "bool_finalizada"));
		oferta.setConcessionaria(concessionariaRegra.construirConcessionaria(row));
		return oferta;
	}

	@Override
	public Oferta buildOferta(ResultSet rs) {
		Oferta oferta = new Oferta();

		oferta.setId(getLong(rs, "idoferta"));
		oferta.setValorDaOferta(getBidDecimal(rs, "db_preco_oferta"));
		oferta.setDataCriado(getGregorianCalendar(rs, "dt_criado"));
		oferta.setVeiculo(veiculoRegra.buildVeiculo(rs));
		oferta.setFinalizado(getBoolean(rs, "bool_finalizada"));
		oferta.setConcessionaria(concessionariaRegra.construirConcessionaria(rs));
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
