package carros.regras.security;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Component;

import carros.entities.usuarios.TipoUsuario;
import carros.regras.CarrosRegras;

@Component
public class TipoUsuarioRegraImpl extends CarrosRegras implements
		TipoUsuarioRegra {

	@Override
	public TipoUsuario buildTipoUsuario(ResultSet rs) {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(getLong(rs, "idtipo_usuario"));
		tipoUsuario
				.setDescricaoTipo(getString(rs, "txt_descricao_tipo_usuario"));
		return tipoUsuario;
	}

	@Override
	public TipoUsuario buildTipoUsuario(Map<String, Object> row) {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(getLong(row, "idtipo_usuario"));
		tipoUsuario.setDescricaoTipo(getString(row,
				"txt_descricao_tipo_usuario"));
		return tipoUsuario;
	}

}
