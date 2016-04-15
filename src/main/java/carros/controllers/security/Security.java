package carros.controllers.security;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import carros.entities.security.LoginForm;
import carros.entities.security.TrocaDeSenha;
import carros.entities.usuarios.Concessionaria;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.Usuario;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.exception.SenhaNaoConfere;
import carros.exception.security.CarrosUserNotFound;
import carros.exception.security.CarrosUsuarioNaoAutenticado;
import carros.exception.security.CarrosUsuarioNaoTemPapel;
import carros.security.session.SessaoAtributoService;
import carros.security.session.TipoUsuarioSessao;
import carros.security.session.UsuarioSessao;
import carros.services.crud.UsuarioCrudService;
import carros.services.security.LoginUserService;

@RestController
@RequestMapping("/security")
@Service
@Scope("request")
public class Security {

	private static final Logger logger = LoggerFactory.getLogger(Security.class);

	private LoginUserService loginUserService;
	private SessaoAtributoService sessaoAtributoService;
	private UsuarioCrudService usuarioCrudService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Serializable> login(@RequestBody LoginForm loginForm)
			throws CarrosUserNotFound, CarrosUsuarioNaoTemPapel, CarrosUsuarioNaoAutenticado {

		Serializable result = loginUserService.loginUser(loginForm);
		iniciarSessao(result);
		return new ResponseEntity<Serializable>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/confirmarEmail", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Serializable> confirmarEmail(@RequestParam(required = true) String token)
			throws Exception {
		logger.debug("token atutenticação: " + token);
		Serializable result = loginUserService.confirmarEmail(token);
		iniciarSessao(result);
		return new ResponseEntity<Serializable>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/sair", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> sair(final HttpServletRequest request,
			final HttpServletResponse response) {

		request.getSession().invalidate();
		request.getSession().setMaxInactiveInterval(1);

		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@RequestMapping(value = "/esqueciSenha", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> esqueciSenha(@RequestBody String email) throws CarrosUserNotFound {
		Usuario usuario = usuarioCrudService.buscarUsuarioPorEmail(email);
		usuarioCrudService.enviarEmailAutenticacao(email, usuario);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/verificarTokenEsqueciSenha", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Usuario> verificarTokenEsqueciSenha(@RequestBody String token) throws CarrosUserNotFound {
		return new ResponseEntity<Usuario>(usuarioCrudService.verificarTokenEsqueciSenha(token)	, HttpStatus.OK);
	}

	@RequestMapping(value = "/trocarSenha", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> changePassword(@RequestBody TrocaDeSenha trocaDeSenha)
			throws SenhaNaoConfere {
		if (trocaDeSenha != null) {
			System.out.println("entoru 1");
			if (trocaDeSenha.getSenhaNova() != null && trocaDeSenha.getSenhaNova().length() > 3) {
				System.out.println("entrou 2");
				if (trocaDeSenha.getSenhaNova().equals(trocaDeSenha.getConfirmacaoSenha())) {
					System.out.println("entrou 3");
					usuarioCrudService.trocarSenha(trocaDeSenha);
					return new ResponseEntity<String>(HttpStatus.OK);

				}
			}
		}
		throw new SenhaNaoConfere();
	}
	
	@RequestMapping(value = "/trocarSenhaComHash", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> changePasswordComHash(@RequestBody TrocaDeSenha trocaDeSenha)
			throws SenhaNaoConfere {
		if (trocaDeSenha != null) {
			if (trocaDeSenha.getSenhaNova() != null && trocaDeSenha.getSenhaNova().length() > 3) {
				if (trocaDeSenha.getSenhaNova().equals(trocaDeSenha.getConfirmacaoSenha())) {
					usuarioCrudService.trocarSenhaComHash(trocaDeSenha);
					return new ResponseEntity<String>(HttpStatus.OK);

				}
			}
		}
		throw new SenhaNaoConfere();
	}

	private void iniciarSessao(Serializable result) throws CarrosUsuarioNaoTemPapel {
		logger.info("Selecionando tipo de usuário");
		if (result instanceof Concessionaria) {
			logger.info("Concessionaria selecionada");
			Concessionaria concessionaria = (Concessionaria) result;
			sessaoAtributoService.iniciarSessao(
					new UsuarioSessao(concessionaria.getUsuario().getIdUsuario(), TipoUsuarioSessao.CONCESSIONARIA));
		} else if (result instanceof UsuarioConcessionaria) {
			logger.info("UsuarioConcessionaria selecionada");
			UsuarioConcessionaria usuarioConcessionaria = (UsuarioConcessionaria) result;
			sessaoAtributoService.iniciarSessao(new UsuarioSessao(usuarioConcessionaria.getUsuario().getIdUsuario(),
					TipoUsuarioSessao.USUARIO_CONCESSIONARIA));
		} else if (result instanceof Lojista) {
			logger.info("Lojista selecionado");
			Lojista lojista = (Lojista) result;
			sessaoAtributoService
					.iniciarSessao(new UsuarioSessao(lojista.getUsuario().getIdUsuario(), TipoUsuarioSessao.LOJISTA));
		} else if (result instanceof Usuario) {
			logger.info("ADMIN selecionado");
			Usuario usuario = (Usuario) result;
			sessaoAtributoService.iniciarSessao(new UsuarioSessao(usuario.getIdUsuario(), TipoUsuarioSessao.ADMIN));
		} else {
			throw new CarrosUsuarioNaoTemPapel("este usuario n�o se enquadra no sistema");
		}
	}

	@Autowired
	public void setLoginUserService(LoginUserService loginUserService) {
		this.loginUserService = loginUserService;
	}

	@Autowired
	public void setSessaoAtributoService(SessaoAtributoService sessaoAtributoService) {
		this.sessaoAtributoService = sessaoAtributoService;
	}

	@Autowired
	public void setUsuarioCrudService(UsuarioCrudService usuarioCrudService) {
		this.usuarioCrudService = usuarioCrudService;
	}

}
