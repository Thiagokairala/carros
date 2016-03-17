package carros.regras.residenciais;

import java.sql.ResultSet;
import java.util.Map;

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
		endereco.setCep(getString(rs, "txt_cep"));
		return endereco;
	}

	@Override
	public Endereco buildEndereco(Map<String, Object> row) {
		Endereco endereco = new Endereco();
		endereco.setId(getLong(row, "idendereco"));
		endereco.setEndereco(getString(row, "txt_endereco"));
		endereco.setCep(getString(row, "txt_cep"));
		return endereco;
	}

}
