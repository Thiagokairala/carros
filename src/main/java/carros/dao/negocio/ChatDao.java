package carros.dao.negocio;

import java.util.List;

import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.UsuarioConcessionaria;

public interface ChatDao {

	public Chat criarChat(Chat chat);

	public List<UsuarioConcessionaria> getUsuariosConcessionariaChat(Long id);

	public void InserirUsuariosConcessionaria(List<UsuarioConcessionaria> usuarios, Long idChat);

	public List<Chat> getChatsLojista(Long idLojista);

	public List<Chat> getChatsUsuarioConcessionaria(Long idUsuarioConcessionaria);

}
