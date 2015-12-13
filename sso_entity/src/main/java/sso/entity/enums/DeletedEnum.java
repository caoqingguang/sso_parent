package sso.entity.enums;

public enum DeletedEnum {
	DELETED(1,"已删"),
	NORMAL(2,"正常");
	private final Integer value;
	private final String name;
	private DeletedEnum(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
}
