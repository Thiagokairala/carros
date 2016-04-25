package carros.entities.atualizarBanco;

import java.io.Serializable;

public class MarcasAtt implements Serializable {

	private static final long serialVersionUID = 7308432909533985805L;

	private String name;
	private String fipe_name;
	private String key;
	private Long id;
	private String order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFipe_name() {
		return fipe_name;
	}

	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
