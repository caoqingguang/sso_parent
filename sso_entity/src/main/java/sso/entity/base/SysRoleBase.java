package sso.entity.base;

import java.util.Date;

@SuppressWarnings("serial")
public class SysRoleBase extends BaseEntity{
	  private String roleName;
	  private Integer roleType;
	  private String roleDefUrl;
	  private Long sysId;
	  private String sysChName;
	  private Date crTime;
	  private Integer deleted;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public String getRoleDefUrl() {
		return roleDefUrl;
	}
	public void setRoleDefUrl(String roleDefUrl) {
		this.roleDefUrl = roleDefUrl;
	}
	public Long getSysId() {
		return sysId;
	}
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	
	public String getSysChName() {
		return sysChName;
	}
	public void setSysChName(String sysChName) {
		this.sysChName = sysChName;
	}
	public Date getCrTime() {
		return crTime;
	}
	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
}
