package carros.regras.security;

import java.sql.ResultSet;

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

}
