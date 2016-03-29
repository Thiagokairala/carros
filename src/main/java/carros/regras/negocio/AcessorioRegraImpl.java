package carros.regras.negocio;

import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.negocio.Acessorio;
import carros.regras.CarrosRegras;

@Component
public class AcessorioRegraImpl extends CarrosRegras implements AcessorioRegra {

	@Override
	public Acessorio buildAcessorio(Map<String, Object> row) {
		Acessorio acessorio = new Acessorio();
		acessorio.setId(getLong(row, "idacessorio_veiculo"));
		acessorio.setNomeAcessorio(getString(row, "txt_nome_acessorio"));
		return acessorio;
	}

}
