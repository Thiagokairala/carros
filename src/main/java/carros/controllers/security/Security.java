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
import carros.entities.usuarios.Concessionaria;
import carros.entities.usuarios.Lojista;
import carros.entities.usuarios.Usuario;
import carros.entities.usuarios.UsuarioConcessionaria;
import carros.exception.security.CarrosUserNotFound;
import carros.exception.security.CarrosUsuarioNaoAutenticado;
import carros.exception.security.CarrosUsuarioNaoTemPapel;
import carros.security.session.SessaoAtributoService;
import carros.security.session.TipoUsuarioSessao;
import carros.security.session.UsuarioSessao;
import carros.services.security.LoginUserService;

@RestController
@RequestMapping("/security")
@Service
@Scope("request")
public class Security {

	private static final Logger logger = LoggerFactory.getLogger(Security.class);

	private LoginUserService LoginUserService;
	private SessaoAtributoService sessaoAtributoService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Serializable> login(@RequestBody LoginForm loginForm)
			throws CarrosUserNotFound, CarrosUsuarioNaoTemPapel, CarrosUsuarioNaoAutenticado {
		logger.info("/security/login");

		Serializable result = LoginUserService.loginUser(loginForm);
		iniciarSessao(result);
		return new ResponseEntity<Serializable>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "confirmarEmail", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Serializable> confirmarEmail(@RequestParam(required = true) String token)
			throws CarrosUsuarioNaoTemPapel, CarrosUserNotFound {
		Serializable result = LoginUserService.confirmarEmail(token);
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

	private void iniciarSessao(Serializable result) throws CarrosUsuarioNaoTemPapel {
		if (result instanceof Concessionaria) {
			Concessionaria concessionaria = (Concessionaria) result;
			sessaoAtributoService.iniciarSessao(
					new UsuarioSessao(concessionaria.getUsuario().getIdUsuario(), TipoUsuarioSessao.CONCESSIONARIA));
		} else if (result instanceof UsuarioConcessionaria) {
			UsuarioConcessionaria usuarioConcessionaria = (UsuarioConcessionaria) result;
			sessaoAtributoService.iniciarSessao(new UsuarioSessao(usuarioConcessionaria.getUsuario().getIdUsuario(),
					TipoUsuarioSessao.USUARIO_CONCESSIONARIA));
		} else if (result instanceof Lojista) {
			Lojista lojista = (Lojista) result;
			sessaoAtributoService
					.iniciarSessao(new UsuarioSessao(lojista.getUsuario().getIdUsuario(), TipoUsuarioSessao.LOJISTA));
		} else if (result instanceof Usuario) {
			Usuario usuario = (Usuario) result;
			sessaoAtributoService.iniciarSessao(new UsuarioSessao(usuario.getIdUsuario(), TipoUsuarioSessao.ADMIN));
		} else {
			throw new CarrosUsuarioNaoTemPapel("este usuario n�o se enquadra no sistema");
		}

	}

	@Autowired
	public void setLoginUserService(LoginUserService loginUserService) {
		this.LoginUserService = loginUserService;
	}

	@Autowired
	public void setSessaoAtributoService(SessaoAtributoService sessaoAtributoService) {
		this.sessaoAtributoService = sessaoAtributoService;
	}

}
