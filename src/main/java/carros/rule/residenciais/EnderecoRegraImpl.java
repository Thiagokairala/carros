package carros.rule.residenciais;

import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import carros.entities.residenciais.Endereco;
import carros.regras.CarrosRegras;

@Component
public class EnderecoRegraImpl extends CarrosRegras implements EnderecoRegra {

	@Override
	public Endereco buildEndereco(ResultSet rs) {
		Endereco endereco = new Endereco();
		endereco.setId(getLong(rs, "idendereco"));
		endereco.setEndereco(getString(rs, "txt_endereco"));
		endereco.setCep(getString(rs, "txt_get"));
		return endereco;
	}

}
