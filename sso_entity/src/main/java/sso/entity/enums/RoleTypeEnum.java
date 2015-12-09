package sso.entity.enums;

public enum RoleTypeEnum {
	SUPPERADMIN(0,"超级用户"),
	ADMIN(1,"admin用户"),
	GENERAL(2,"普通用户");
	private final Integer value;
	private final String name;
	private RoleTypeEnum(Integer value, String name) {
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
