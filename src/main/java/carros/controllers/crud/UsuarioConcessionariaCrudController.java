package carros.controllers.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carros.entities.usuarios.NivelUsuarioConcessionaria;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.services.crud.UsuarioConcessionariaCrudService;
import carros.services.crud.UsuarioCrudService;

@RestController
@Service
@Scope("request")
@RequestMapping("/usuarioConcessionaria")
public class UsuarioConcessionariaCrudController {

	private UsuarioConcessionariaCrudService usuarioConcessionariaCrudService;
	private UsuarioCrudService usuarioCrudService;

	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UsuarioConcessionaria> inserirUsuarioConcessionaria(
			@RequestBody UsuarioConcessionaria usuarioConcessionaria) throws Exception {
		return new ResponseEntity<UsuarioConcessionaria>(
				usuarioConcessionariaCrudService.inserirUsuarioConcessionaria(usuarioConcessionaria), HttpStatus.OK);
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<UsuarioConcessionaria>> buscarUsuariosConcessionaria(
			@RequestParam Long idConcessionaria) {

		return new ResponseEntity<List<UsuarioConcessionaria>>(
				usuarioConcessionariaCrudService.listarUsuarios(idConcessionaria), HttpStatus.OK);
	}

	@RequestMapping(value = "/trocarStatus", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<UsuarioConcessionaria> trocarStatusUsuario(
			@RequestBody UsuarioConcessionaria usuario) {
		usuario.setUsuario(usuarioCrudService.trocarStatusUsuario(usuario.getUsuario()));
		return new ResponseEntity<UsuarioConcessionaria>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value="/listarTiposUsuario", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<NivelUsuarioConcessionaria>> listarNiveisUsuarioConcessionaria() {
		return new ResponseEntity<List<NivelUsuarioConcessionaria>>(usuarioConcessionariaCrudService.getNiveisUsuarios(), HttpStatus.OK);
	}
	
	@Autowired
	public void setUsuarioConcessionariaCrudService(UsuarioConcessionariaCrudService usuarioConcessionariaCrudService) {
		this.usuarioConcessionariaCrudService = usuarioConcessionariaCrudService;
	}

	@Autowired
	public void setUsuarioCrudService(UsuarioCrudService usuarioCrudService) {
		this.usuarioCrudService = usuarioCrudService;
	}

}
