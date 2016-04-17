package carros.services.external;

import org.springframework.stereotype.Service;

import carros.entities.usuarios.Usuario;

@Service
public class EmailHtmlFormatter {

	private String cofirmationUrl = "http://localhost:8080/carrosWeb/#/main/confirmEmail/";
	private String changePasswordUrl = "http://localhost:8080/carrosWeb/#/main/forgotPasswordConfirm/";

	public String formatarEmail(Usuario usuario) {
		cofirmationUrl += usuario.getTokenAutenticacao();
		String email = "<h1>A empresa " + usuario.getPessoa().getNome() + " se cadastrou</h1>";
		email += "<p>Entre em contato pelo email <a href='mailto:" + usuario.getEmail() + "'>" + usuario.getEmail()
				+ "</a> ou pelo telefone (" + usuario.getPessoa().getTelefone().getDdd() + ") "
				+ usuario.getPessoa().getTelefone().getNumeroDeTelefone() + "</p>";
		email += "<div>" +
				"  <p>" +
				"    Nome da empresa: " + usuario.getPessoa().getNome() +
				"  </p>" +
				"  <p>"+
				"    CNPJ da empresa: " + usuario.getPessoa().getDocIdentificacao() +
				"  </p>"+
				"  <p>"+
				"    Endereço da empresa: " + usuario.getPessoa().getEndereco().getEndereco() +
				"  </p>"+
				"  <p>"+
				"    Cep: " + usuario.getPessoa().getEndereco().getCep() +
				"  </p>" +
				"</div>";
		email += "<p>Para finalizar o registro clique <a href='" + cofirmationUrl + "'>aqui</a></p>";
		return email;
	}

	public Object formatarEmailTrocaSenha(String hash, String email) {
		changePasswordUrl += hash;
		String emailText = "<h1>Você solicitou um reset na sua senha</h1>";
		emailText += "<p>Para completar siga o <a href='" + changePasswordUrl + "'>link</a></p>";
		return emailText;
	}
}
