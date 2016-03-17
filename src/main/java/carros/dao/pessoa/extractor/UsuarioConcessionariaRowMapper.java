package carros.dao.pessoa.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import carros.entities.usuarios.UsuarioConcessionaria;
import carros.regras.pessoa.UsuarioConcessionariaRegra;

@Service
public class UsuarioConcessionariaRowMapper implements
		RowMapper<UsuarioConcessionaria> {
	private UsuarioConcessionariaRegra usuarioConcessionariaRegra;

	@Override
	public UsuarioConcessionaria mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		return usuarioConcessionariaRegra.buildUsuarioConcessionaria(rs);
	}

	@Autowired
	public void setUsuarioConcessionariaRegra(
			UsuarioConcessionariaRegra usuarioConcessionariaRegra) {
		this.usuarioConcessionariaRegra = usuarioConcessionariaRegra;
	}

}
