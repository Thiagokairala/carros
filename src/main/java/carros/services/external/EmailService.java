package carros.services.external;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carros.entities.usuarios.Usuario;

@Service
public class EmailService {

	private AutenticacaoEmail autenticacaoEmail;
	private EmailHtmlFormatter emailHtmlFormatter;

	public void sendActivationEmail(Usuario usuario) {

		Properties propriedades = preparaProperties(usuario);

		autenticacaoEmail.setUsername(EmailContrato.USUARIO_EMAIL);
		autenticacaoEmail.setPassword(EmailContrato.SENHA_EMAIL);

		Session session = Session.getDefaultInstance(propriedades, autenticacaoEmail);
		session.setDebug(true);

		Message mensagem = preparaMensage(session, usuario);

		enviarTransport(mensagem, session);

	}

	private void enviarTransport(Message mensagem, Session session) {
		Transport transport;
		try {
			transport = session.getTransport("smtp");
			transport.connect(EmailContrato.MAIL_SMTP_SERVER, EmailContrato.USUARIO_EMAIL, EmailContrato.SENHA_EMAIL);
			mensagem.saveChanges(); // don't forget this
			transport.sendMessage(mensagem, mensagem.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
		}
	}

	private Message preparaMensage(Session session, Usuario usuario) {
		Message mensagem = new MimeMessage(session);
		try {
			mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getEmail()));
			mensagem.setFrom(new InternetAddress(EmailContrato.EMAIL_FROM));
			mensagem.setSubject("confirmação de registro");
			mensagem.setContent(emailHtmlFormatter.formatarEmail(usuario), "text/html");
		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}
		return mensagem;
	}

	private Properties preparaProperties(Usuario usuario) {
		Properties propriedades = new Properties();
		propriedades.put("mail.transport.protocol", "smtp");
		propriedades.put("mail.smtp.starttls.enable", "true");
		propriedades.put("mail.smtp.host", EmailContrato.MAIL_SMTP_SERVER);
		propriedades.put("mail.smtp.auth", "true");
		propriedades.put("mail.smtp.user", EmailContrato.EMAIL_FROM);
		propriedades.put("mail.debug", "true");
		propriedades.put("mail.smtp.port", EmailContrato.MAIL_SMTP_SERVER_PORT);
		propriedades.put("mail.smtp.socketFactory.port", EmailContrato.MAIL_SMTP_SERVER_PORT);
		propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		propriedades.put("mail.smtp.socketFactory.fallback", "false");
		propriedades.put("mail.mime.charset", "UTF-8");
		return propriedades;
	}

	@Autowired
	public void setAutenticacaoEmail(AutenticacaoEmail autenticacaoEmail) {
		this.autenticacaoEmail = autenticacaoEmail;
	}

	@Autowired
	public void setEmailHtmlFormatter(EmailHtmlFormatter emailHtmlFormatter) {
		this.emailHtmlFormatter = emailHtmlFormatter;
	}

}
