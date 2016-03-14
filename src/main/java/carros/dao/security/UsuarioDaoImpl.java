package carros.dao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import carros.entities.usuarios.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private JdbcTemplate JdbcTemplate;

	@Override
	public void inserirUsuario(Usuario usuario) {

	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

}
