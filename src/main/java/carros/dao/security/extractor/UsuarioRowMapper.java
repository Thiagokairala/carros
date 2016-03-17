package carros.dao.security.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import carros.entities.usuarios.Usuario;
import carros.regras.security.UsuarioRegra;

@Service
public class UsuarioRowMapper implements RowMapper<Usuario> {
	private UsuarioRegra usuarioRegra;

	@Override
	public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
		return usuarioRegra.buildUsuario(rs);
	}

	@Autowired
	public void setUsuarioRegra(UsuarioRegra usuarioRegra) {
		this.usuarioRegra = usuarioRegra;
	}

}
