package carros.dao.pessoa.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import carros.entities.usuarios.Concessionaria;
import carros.rule.pessoa.ConcessionariaRegra;

@Service
public class ConcessionariaRowMapper implements RowMapper<Concessionaria> {
	ConcessionariaRegra concessionariaRegra;

	@Override
	public Concessionaria mapRow(ResultSet rs, int arg1) throws SQLException {
		return concessionariaRegra.construirConcessionaria(rs);
	}

	@Autowired
	public void setConcessionariaRegra(ConcessionariaRegra concessionariaRegra) {
		this.concessionariaRegra = concessionariaRegra;
	}

}
