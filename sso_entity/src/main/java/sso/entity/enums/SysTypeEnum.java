package sso.entity.enums;

public enum SysTypeEnum {
	ADMIN(1,"admin系统"),
	NORMAL(2,"普通系统");
	private final Integer value;
	private final String name;
	private SysTypeEnum(Integer value, String name) {
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
