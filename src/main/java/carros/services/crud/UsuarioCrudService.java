package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.security.UsuarioDao;
import carros.entities.usuarios.Usuario;

@Service
public class UsuarioCrudService {
	private UsuarioDao usuarioDao;

	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioDao.inserirUsuario(usuario);
	}

	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
