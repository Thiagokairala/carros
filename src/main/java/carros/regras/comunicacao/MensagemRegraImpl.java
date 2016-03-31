package carros.regras.comunicacao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carros.entities.comunicacao.Mensagem;
import carros.regras.CarrosRegras;
import carros.regras.pessoa.aparencia.ImagemRegra;
import carros.regras.security.UsuarioRegra;

@Component
public class MensagemRegraImpl extends CarrosRegras implements MensagemRegra {

	private ChatRegra chatRegra;
	private ImagemRegra imagemRegra;
	private UsuarioRegra usuarioRegra;

	@Override
	public Mensagem buildMensagem(Map<String, Object> row) {
		Mensagem mensagem = new Mensagem();
		mensagem.setChat(chatRegra.buildRegra(row));
		mensagem.setDataEnvio(getGregorianCalendar(row, "dt_envio"));
		mensagem.setId(getLong(row, "idmensagem"));
		mensagem.setImagem(imagemRegra.buildImagem(row));
		mensagem.setMensagem(getString(row, "txt_mensagem"));
		mensagem.setNomeRemetente(getString(row, "txt_nomeDeTela"));
		mensagem.setUsuario(usuarioRegra.buildUsuario(row));
		return mensagem;
	}

	@Autowired
	public void setChatRegra(ChatRegra chatRegra) {
		this.chatRegra = chatRegra;
	}

	@Autowired
	public void setImagemRegra(ImagemRegra imagemRegra) {
		this.imagemRegra = imagemRegra;
	}

	@Autowired
	public void setUsuarioRegra(UsuarioRegra usuarioRegra) {
		this.usuarioRegra = usuarioRegra;
	}

}
