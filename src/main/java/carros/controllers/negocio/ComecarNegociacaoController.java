package carros.controllers.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.controllers.ControladoraBase;
import carros.entities.auxiliar.Negociacao;
import carros.entities.comunicacao.Chat;
import carros.entities.usuarios.Lojista;
import carros.services.negocio.NegociacaoService;

@RestController
@Service
@RequestMapping("/negociacao")
@Scope("request")
public class ComecarNegociacaoController extends ControladoraBase {

	private NegociacaoService negociacaoService;

	@RequestMapping(value = "/comecar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Chat> comecarNegociacao(@RequestBody Negociacao negociacao) throws Exception {
		Lojista lojista = super.usuarioSessaoEhLojista();
		Chat chat = negociacaoService.abrirNegociacoes(negociacao, lojista);
		if(chat == null) {
			return new ResponseEntity<Chat>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Chat>(chat, HttpStatus.OK);		
		}
	
	}

	@Autowired
	public void setNegociacaoService(NegociacaoService negociacaoService) {
		this.negociacaoService = negociacaoService;
	}

}
