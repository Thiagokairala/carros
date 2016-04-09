package carros.services.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.UsuarioConcessionariaDao;
import carros.entities.usuarios.UsuarioConcessionaria;

@Service
public class UsuarioConcessionariaCrudService {

	private UsuarioConcessionariaDao usuarioConcessionariaDao;

	public UsuarioConcessionaria inserirUsuarioConcessionaria(
			UsuarioConcessionaria usuarioConcessionaria) {
		return usuarioConcessionariaDao
				.inserirUsuarioConcessionaria(usuarioConcessionaria);
	}

	@Autowired
	public void setUsuarioConcessionariaDao(
			UsuarioConcessionariaDao usuarioConcessionariaDao) {
		this.usuarioConcessionariaDao = usuarioConcessionariaDao;
	}

	public List<UsuarioConcessionaria> listarUsuarios(Long idConcessionaria) {
		// TODO Auto-generated method stub
		return usuarioConcessionariaDao.buscarUsuariosDeUmaConcessionaria(idConcessionaria);
	}

}
