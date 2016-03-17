package carros.regras.pessoa;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.usuarios.UsuarioConcessionaria;
import carros.regras.CarrosRegras;
import carros.regras.security.UsuarioRegra;

@Component
public class UsuarioConcessionariaRegraImpl extends CarrosRegras implements
		UsuarioConcessionariaRegra {
	private UsuarioRegra usuarioRegra;
	private ConcessionariaRegra concessionariaRegra;
	private NivelUsuarioConcessionariaRegra nivelUsuarioConcessionariaRegra;

	@Override
	public UsuarioConcessionaria buildUsuarioConcessionaria(ResultSet rs) {
		UsuarioConcessionaria usuarioConcessionaria = new UsuarioConcessionaria();

		usuarioConcessionaria.setUsuario(usuarioRegra.buildUsuario(rs));
		usuarioConcessionaria.setIdUsuarioConcessionaria(getLong(rs,
				"idusuario_concessionaria"));
		usuarioConcessionaria.setConcessionaria(concessionariaRegra
				.construirConcessionaria(rs));
		usuarioConcessionaria
				.setNivelUsuarioConcessionaria(nivelUsuarioConcessionariaRegra
						.buildNivelUsuarioConcessionaria(rs));

		return usuarioConcessionaria;
	}

	@Autowired
	public void setUsuarioRegra(UsuarioRegra usuarioRegra) {
		this.usuarioRegra = usuarioRegra;
	}

	@Autowired
	public void setConcessionariaRegra(ConcessionariaRegra concessionariaRegra) {
		this.concessionariaRegra = concessionariaRegra;
	}

	@Autowired
	public void setNivelUsuarioConcessionariaRegra(
			NivelUsuarioConcessionariaRegra nivelUsuarioConcessionariaRegra) {
		this.nivelUsuarioConcessionariaRegra = nivelUsuarioConcessionariaRegra;
	}

}
