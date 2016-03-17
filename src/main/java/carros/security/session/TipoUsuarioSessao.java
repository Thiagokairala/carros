package carros.security.session;

public enum TipoUsuarioSessao {


	NONE(0), CONCESSIONARIA(1), LOJISTA(2), USUARIO_CONCESSIONARIA(3), ADMIN(4);

	private int typeCode;

	private TipoUsuarioSessao(int typeCode) {
		this.typeCode = typeCode;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public static TipoUsuarioSessao get(final int typeCode) {
		TipoUsuarioSessao tipoUsuarioSessoa = NONE;
		for (final TipoUsuarioSessao userType : values()) {
			if (userType.getTypeCode() == typeCode) {
				tipoUsuarioSessoa = userType;
				break;
			}
		}
		return tipoUsuarioSessoa;
	}

	public static boolean isConcessionaria(final TipoUsuarioSessao tipoUsuarioSessoa) {
		return CONCESSIONARIA.equals(tipoUsuarioSessoa);
	}

	public static boolean isLojista(final TipoUsuarioSessao tipoUsuarioSessoa) {
		return LOJISTA.equals(tipoUsuarioSessoa);
	}

	public static boolean isUsuarioConcessionaria(
			final TipoUsuarioSessao tipoUsuarioSessoa) {
		return USUARIO_CONCESSIONARIA.equals(tipoUsuarioSessoa);
	}

	public static boolean isAdmin(final TipoUsuarioSessao tipoUsuarioSessoa) {
		return ADMIN.equals(tipoUsuarioSessoa);
	}

	public static boolean isConcessionaria(final int typeCode) {
		return CONCESSIONARIA.getTypeCode() == typeCode;
	}

	public static boolean isLojista(final int typeCode) {
		return LOJISTA.getTypeCode() == typeCode;
	}

	public static boolean isUsuarioConcessionaria(final int typeCode) {
		return USUARIO_CONCESSIONARIA.getTypeCode() == typeCode;
	}

	public static boolean isAdmin(final int typeCode) {
		return ADMIN.getTypeCode() == typeCode;
	}
}
