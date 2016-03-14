package carros.entities.usuarios;

import java.io.Serializable;

public class UsuarioConcessionaria extends Usuario implements Serializable {

	private static final long serialVersionUID = -4820465643086366525L;

	private Long id;
	private NivelUsuarioConcessionaria nivelUsuarioConcessionaria;

}
