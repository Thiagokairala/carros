package carros.services.security.password;

import org.springframework.stereotype.Service;

import carros.util.codificacao.UtilCodificacao;

@Service
public class PasswordHandlerImpl implements PasswordHandler {

	@Override
	public String criptografarSenha(String senha) {
		return UtilCodificacao.gerarHash(senha, "SHA-256");
	}
}
