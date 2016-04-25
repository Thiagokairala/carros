package carros.regras.pessoa;

import java.sql.ResultSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.usuarios.Concessionaria;
import carros.regras.CarrosRegras;
import carros.regras.security.UsuarioRegra;

@Component
public class ConcessionariaRegraImpl extends CarrosRegras implements
		ConcessionariaRegra {
	private UsuarioRegra usuarioRegra;

	@Override
	public Concessionaria construirConcessionaria(ResultSet rs) {
		Concessionaria concessionaria = new Concessionaria();
		concessionaria.setUsuario(usuarioRegra.buildUsuario(rs));

		concessionaria.setIdConcessionaria(getLong(rs, "idconcessionaria"));
		concessionaria.setNumeroAvaliacoes(getInt(rs,
				"int_numero_de_avaliacoes"));
		concessionaria.setNotaGeral(getDouble(rs, "fl_nota_avaliacao"));
		concessionaria.setResponsavel(getString(rs, "txt_responsavel"));

		return concessionaria;
	}

	@Override
	public Concessionaria construirConcessionaria(Map<String, Object> row) {
		Concessionaria concessionaria = new Concessionaria();
		concessionaria.setUsuario(usuarioRegra.buildUsuario(row));

		concessionaria.setIdConcessionaria(getLong(row, "idconcessionaria"));
		concessionaria.setNumeroAvaliacoes(getInt(row,
				"int_numero_de_avaliacoes"));
		concessionaria.setNotaGeral(getDouble(row, "fl_nota_avaliacao"));
		concessionaria.setResponsavel(getString(row, "txt_responsavel"));

		return concessionaria;
	}

	@Autowired
	public void setUsuarioRegra(UsuarioRegra usuarioRegra) {
		this.usuarioRegra = usuarioRegra;
	}

}
