package carros.services.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.entities.usuarios.NivelUsuarioConcessionaria;
import carros.entities.usuarios.TipoUsuario;
import carros.entities.usuarios.TipoUsuarioConst;
import carros.entities.usuarios.UsuarioConcessionaria;

@Service
public class UsuarioConcessionariaCrudService {

	private UsuarioConcessionariaDao usuarioConcessionariaDao;

	public UsuarioConcessionaria inserirUsuarioConcessionaria(UsuarioConcessionaria usuarioConcessionaria) throws Exception {
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setId(new Long(TipoUsuarioConst.USUARIO_CONCESSIONARIA.tipoUsuario));
		usuarioConcessionaria.getUsuario().setTipoUsuario(tipoUsuario);
		return usuarioConcessionariaDao.inserirUsuarioConcessionaria(usuarioConcessionaria);
	}

	@Autowired
	public void setUsuarioConcessionariaDao(UsuarioConcessionariaDao usuarioConcessionariaDao) {
		this.usuarioConcessionariaDao = usuarioConcessionariaDao;
	}

	public List<UsuarioConcessionaria> listarUsuarios(Long idConcessionaria) {
		return usuarioConcessionariaDao.buscarUsuariosDeUmaConcessionaria(idConcessionaria);
	}

	public List<NivelUsuarioConcessionaria> getNiveisUsuarios() {
		return usuarioConcessionariaDao.buscarNiveisUsuario();
	}

}
