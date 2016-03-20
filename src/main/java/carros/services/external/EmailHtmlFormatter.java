package carros.services.external;

import org.springframework.stereotype.Service;

import carros.entities.usuarios.Usuario;

@Service
public class EmailHtmlFormatter {

	private String cofirmationUrl = "http://localhost:8080/carros/security/confirmarEmail?token=";

	public String formatarEmail(Usuario usuario) {
		cofirmationUrl += usuario.getTokenAutenticacao();
		String email = "<h1>Você se registrou,</h1>";
		email += "<p>Para finalizar o registro clique <a href='" + cofirmationUrl + "'>aqui</a></p>";
		System.out.println(email);
		return email;
	}
}
