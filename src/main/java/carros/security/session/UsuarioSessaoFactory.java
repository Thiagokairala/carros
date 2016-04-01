package carros.security.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UsuarioSessaoFactory extends AbstractFactoryBean<UsuarioSessao> implements Serializable {

	private static final long serialVersionUID = 6948849144806031803L;

	static String CARROS_SESSION_USER = "carros.security.session.user@security.carros.com.br";

	private HttpServletRequest request;

	private UsuarioSessao sessionUser;

	@Override
	public boolean isSingleton() {
		return false;
	}

	public UsuarioSessaoFactory() {
		super();
	}

	public Class<UsuarioSessao> getObjectType() {
		return UsuarioSessao.class;
	}

	@Autowired
	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}

	private void buildObject() {
		if (request == null) {
			return;
		}

		final HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}

		this.sessionUser = (UsuarioSessao) session.getAttribute(CARROS_SESSION_USER);

	}

	@Override
	public UsuarioSessao createInstance() throws Exception {
		buildObject();
		return sessionUser;
	}

	public UsuarioSessao getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(UsuarioSessao sessionUser) {
		this.sessionUser = sessionUser;
	}
}
