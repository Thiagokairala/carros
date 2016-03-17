package carros.regras.security;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.usuarios.Usuario;
import carros.regras.CarrosRegras;
import carros.regras.pessoa.PessoaRegra;

@Component
public class UsuarioRegraImpl extends CarrosRegras implements UsuarioRegra {

	private PessoaRegra pessoaRegra;
	private TipoUsuarioRegra tipoUsuarioRegra;

	@Override
	public Usuario buildUsuario(ResultSet rs) {
		Usuario usuario = new Usuario();
		usuario.setPessoa(pessoaRegra.buildPessoa(rs));
		usuario.setIdUsuario(getLong(rs, "idusuario"));
		usuario.setUsername(getString(rs, "txt_nome_usuario"));
		usuario.setEmail(getString(rs, "txt_email"));
		usuario.setTipoUsuario(tipoUsuarioRegra.buildTipoUsuario(rs));

		return usuario;
	}

	@Autowired
	public void setPessoaRegra(PessoaRegra pessoaRegra) {
		this.pessoaRegra = pessoaRegra;
	}

	@Autowired
	public void setTipoUsuarioRegra(TipoUsuarioRegra tipoUsuarioRegra) {
		this.tipoUsuarioRegra = tipoUsuarioRegra;
	}

}
