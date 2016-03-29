package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.usuarios.NivelUsuarioConcessionaria;
import carros.regras.CarrosRegras;

@Component
public class NivelUsuarioConcessionariaRegraImpl extends CarrosRegras implements NivelUsuarioConcessionariaRegra {

	@Override
	public NivelUsuarioConcessionaria buildNivelUsuarioConcessionaria(ResultSet rs) {
		NivelUsuarioConcessionaria nivelUsuarioConcessionaria = new NivelUsuarioConcessionaria();

		nivelUsuarioConcessionaria.setId(getLong(rs, "idnivel_usuario_concessionaria"));
		nivelUsuarioConcessionaria.setNivel(getString(rs, "txt_descricao_nivel"));

		return nivelUsuarioConcessionaria;
	}

	@Override
	public NivelUsuarioConcessionaria buildNivelUsuarioConcessionaria(Map<String, Object> row) {
		NivelUsuarioConcessionaria nivelUsuarioConcessionaria = new NivelUsuarioConcessionaria();

		nivelUsuarioConcessionaria.setId(getLong(row, "idnivel_usuario_concessionaria"));
		nivelUsuarioConcessionaria.setNivel(getString(row, "txt_descricao_nivel"));

		return nivelUsuarioConcessionaria;
	}

}
