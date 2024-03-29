package carros.regras.residenciais;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.residenciais.Telefone;
import carros.regras.CarrosRegras;

@Component
public class TelefoneRegraImpl extends CarrosRegras implements TelefoneRegra {

	@Override
	public Telefone buildTelefone(ResultSet rs) {
		Telefone telefone = new Telefone();
		telefone.setId(getLong(rs, "idtelefone"));
		telefone.setDdd(getString(rs, "txt_ddd"));
		telefone.setNumeroDeTelefone(getString(rs, "txt_numero"));
		return telefone;
	}

	@Override
	public Telefone buildTelefone(Map<String, Object> row) {
		Telefone telefone = new Telefone();
		telefone.setId(getLong(row, "idtelefone"));
		telefone.setDdd(getString(row, "txt_ddd"));
		telefone.setNumeroDeTelefone(getString(row, "txt_numero"));
		return telefone;
	}

}
