package sso.util.framework.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SupperBaseEntity implements Serializable {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
