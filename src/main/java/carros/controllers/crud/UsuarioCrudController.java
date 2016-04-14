package carros.controllers.crud;

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

import carros.entities.usuarios.Usuario;
import carros.services.crud.UsuarioCrudService;

@RestController
@RequestMapping("/usuario")
@Service
@Scope("request")
public class UsuarioCrudController {

	private UsuarioCrudService usuarioCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Usuario> inserirUsuario(
			@RequestBody Usuario usuario) throws Exception {
		return new ResponseEntity<Usuario>(
				usuarioCrudService.inserirUsuario(usuario), HttpStatus.OK);
	}

	@Autowired
	public void setUsuarioCrudService(UsuarioCrudService usuarioCrudService) {
		this.usuarioCrudService = usuarioCrudService;
	}

}
