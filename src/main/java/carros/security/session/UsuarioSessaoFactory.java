package carros.security.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioSessaoFactory implements Serializable {

	private static final long serialVersionUID = 6948849144806031803L;

	static String CARROS_SESSION_USER = "carros.security.session.user@security.carros.com.br";

	private HttpServletRequest request;

	private UsuarioSessao sessionUser;

	@Autowired
	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}

	public UsuarioSessaoFactory() {
		super();
	}

	public UsuarioSessao getObject() throws Exception {
		if (sessionUser == null) {
			buildObject();
		}
		return sessionUser;
	}

	public Class<UsuarioSessao> getObjectType() {
		return UsuarioSessao.class;
	}

	/**
	 * 
	 * @return
	 */
	private void buildObject() {
		if (request == null) {
			return;
		}

		final HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}

		this.sessionUser = (UsuarioSessao) session
				.getAttribute(CARROS_SESSION_USER);

	}
}
