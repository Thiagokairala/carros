package carros.regras.security;

import java.sql.ResultSet;
import java.util.Map;

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
		usuario.setAutenticado(getBoolean(rs, "bool_autenticado"));
		usuario.setAtivo(getBoolean(rs, "bool_ativo"));
		return usuario;
	}

	@Override
	public Usuario buildUsuario(Map<String, Object> row) {
		Usuario usuario = new Usuario();
		usuario.setPessoa(pessoaRegra.buildPessoa(row));
		usuario.setIdUsuario(getLong(row, "idusuario"));
		usuario.setUsername(getString(row, "txt_nome_usuario"));
		usuario.setEmail(getString(row, "txt_email"));
		usuario.setTipoUsuario(tipoUsuarioRegra.buildTipoUsuario(row));
		usuario.setAutenticado(getBoolean(row, "bool_autenticado"));
		usuario.setAtivo(getBoolean(row, "bool_ativo"));

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
