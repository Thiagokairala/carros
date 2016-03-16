package carros.rule.pessoa;

import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import carros.entities.usuarios.Concessionaria;
import carros.regras.CarrosRegras;

@Component
public class ConcessionariaRegraImpl extends CarrosRegras implements ConcessionariaRegra {

	@Override
	public Concessionaria construirConcessionaria(ResultSet rs) {
		Concessionaria concessionaria = new Concessionaria();

		concessionaria.setIdConcessionaria(getLong(rs,"idconcessionaria"));
		concessionaria.setNumeroAvaliacoes(getInt(rs,"int_numero_de_avaliacoes"));
		concessionaria.setNotaGeral(getDouble(rs,"fl_nota_avaliacao"));
		
		return concessionaria;
	}

}
