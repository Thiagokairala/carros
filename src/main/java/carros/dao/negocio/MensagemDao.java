package carros.dao.negocio;

import java.util.List;

import carros.entities.comunicacao.Mensagem;

public interface MensagemDao {

	public Mensagem cadastrarMensagem(Mensagem mensagem);

	public List<Mensagem> buscarMensagensChat(Long id);

}
