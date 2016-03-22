package carros.security.session;

import java.io.Serializable;

public class UsuarioSessao implements Serializable {

	private static final long serialVersionUID = -6722612681222839327L;

	private Long sessionUserId = 0L;
	private TipoUsuarioSessao tipoUsuarioSessao = TipoUsuarioSessao.NONE;

	public UsuarioSessao(final Long sessionUserId, final TipoUsuarioSessao tipoUsuarioSessao) {
		super();
		if (sessionUserId == null || sessionUserId.longValue() <= 0) {
			throw new IllegalArgumentException("sessionUserId");
		}
		this.sessionUserId = sessionUserId;
		if (tipoUsuarioSessao == null) {
			throw new IllegalArgumentException("sessionUserType");
		}
		this.tipoUsuarioSessao = tipoUsuarioSessao;
	}

	public Long getSessionUserId() {
		return sessionUserId;
	}

	public TipoUsuarioSessao getSessionUserType() {
		return tipoUsuarioSessao;
	}

	public boolean isConcessionaria() {
		return tipoUsuarioSessao == TipoUsuarioSessao.CONCESSIONARIA;
	}

	public boolean isLojista() {
		return tipoUsuarioSessao == TipoUsuarioSessao.LOJISTA;
	}

	public boolean isUsuarioConcessionaria() {
		return tipoUsuarioSessao == TipoUsuarioSessao.USUARIO_CONCESSIONARIA;
	}

	public boolean isAdmin() {
		return tipoUsuarioSessao == TipoUsuarioSessao.ADMIN;
	}
}
