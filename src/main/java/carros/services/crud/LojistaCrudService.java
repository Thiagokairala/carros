package carros.services.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.dao.pessoa.LojistaDao;
import carros.entities.security.TipoUsuarioContrato;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.TipoUsuario;
import carros.services.external.EmailService;

@Service
public class LojistaCrudService {
	private LojistaDao lojistaDao;
	private EmailService emailService;

	public Lojista inserirLojista(Lojista lojista) {
		TipoUsuario tipoUsuario = new TipoUsuario();

		tipoUsuario.setId(TipoUsuarioContrato.LOJISTA);
		lojista.getUsuario().setTipoUsuario(tipoUsuario);

		lojista = lojistaDao.inserirLojista(lojista);

		if (lojista.getIdLojista() > 0) {
			enviarEmailLojista(lojista);
		}
		return lojista;
	}

	private void enviarEmailLojista(Lojista lojista) {
		emailService.sendActivationEmail(lojista.getUsuario());
	}

	@Autowired
	public void setLojistaDao(LojistaDao lojistaDao) {
		this.lojistaDao = lojistaDao;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

}
