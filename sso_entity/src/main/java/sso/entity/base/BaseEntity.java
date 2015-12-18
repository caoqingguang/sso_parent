package sso.entity.base;

import java.io.Serializable;

import sso.util.framework.entity.SupperBaseEntity;

public class BaseEntity extends SupperBaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
