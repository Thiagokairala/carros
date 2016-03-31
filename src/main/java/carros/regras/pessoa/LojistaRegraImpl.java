package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.usuarios.Lojista;
import carros.regras.CarrosRegras;
import carros.regras.security.UsuarioRegra;

@Component
public class LojistaRegraImpl extends CarrosRegras implements LojistaRegra {
	private UsuarioRegra usuarioRegra;

	@Override
	public Lojista buildLojista(ResultSet rs) {
		Lojista lojista = new Lojista();
		lojista.setIdLojista(getLong(rs, "idlojista"));
		lojista.setUsuario(usuarioRegra.buildUsuario(rs));
		return lojista;
	}

	@Override
	public Lojista buildLojista(Map<String, Object> row) {
		Lojista lojista = new Lojista();
		lojista.setIdLojista(getLong(row, "idlojista"));
		lojista.setUsuario(usuarioRegra.buildUsuario(row));
		return lojista;
	}

	@Autowired
	public void setUsuarioRegra(UsuarioRegra usuarioRegra) {
		this.usuarioRegra = usuarioRegra;
	}

}
