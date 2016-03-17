package carros.dao.pessoa.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import carros.entities.usuarios.Lojista;
import carros.regras.pessoa.LojistaRegra;

@Service
public class LojistaRowMapper implements RowMapper<Lojista> {
	private LojistaRegra lojistaRegra;

	@Override
	public Lojista mapRow(ResultSet rs, int rowNum) throws SQLException {
		return lojistaRegra.buildLojista(rs);
	}

	@Autowired
	public void setLojistaRegra(LojistaRegra lojistaRegra) {
		this.lojistaRegra = lojistaRegra;
	}

}
