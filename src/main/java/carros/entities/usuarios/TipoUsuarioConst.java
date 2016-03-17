package carros.entities.usuarios;

public enum TipoUsuarioConst {
	ADMIN(1), CONCESSIONARIA(2), USUARIO_CONCESSIONARIA(3), LOJISTA(4);
	public int tipoUsuario;

	private TipoUsuarioConst(int valor) {
		this.tipoUsuario = valor;
	}

	public int getTipoUsuarioConst() {
		return tipoUsuario;
	}
}
