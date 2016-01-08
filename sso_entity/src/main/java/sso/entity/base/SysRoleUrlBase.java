package sso.entity.base;


@SuppressWarnings("serial")
public class SysRoleUrlBase extends BaseEntity{

	  private Long roleId;
	  private Long urlId;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getUrlId() {
		return urlId;
	}
	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}
	  
}
