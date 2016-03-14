package carros.dao.security;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import carros.entities.usuarios.Usuario;

@Repository
public class UsuarioDaoImpl extends JdbcDaoSupport implements UsuarioDao {

	@Override
	public void inserirUsuario(Usuario usuario) {

	}

}
