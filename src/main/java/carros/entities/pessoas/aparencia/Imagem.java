package carros.entities.pessoas.aparencia;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Imagem implements Serializable {

	private static final long serialVersionUID = -1142561629070321987L;

	private Long id;
	private String caminhoImagem;
	private String hashImagem;
	private GregorianCalendar dataInclusao;
}
