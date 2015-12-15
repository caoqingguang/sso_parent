package sso.entity.base;

import java.util.Date;

@SuppressWarnings("serial")
public class SysBase extends BaseEntity{
	private String sysName;
	private String sysChName;
	private String indexStr;
	private String defUrl;
	private Integer sysLev;
	private Integer sysType;
	private Date crTime;
	private String regPw;
	private String regPrefix;
	private String regNullUrl;
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getSysChName() {
		return sysChName;
	}
	public void setSysChName(String sysChName) {
		this.sysChName = sysChName;
	}
	public String getIndexStr() {
		return indexStr;
	}
	public void setIndexStr(String indexStr) {
		this.indexStr = indexStr;
	}
	public String getDefUrl() {
		return defUrl;
	}
	public void setDefUrl(String defUrl) {
		this.defUrl = defUrl;
	}
	public Integer getSysLev() {
		return sysLev;
	}
	public void setSysLev(Integer sysLev) {
		this.sysLev = sysLev;
	}
	public Integer getSysType() {
		return sysType;
	}
	public void setSysType(Integer sysType) {
		this.sysType = sysType;
	}
	public Date getCrTime() {
		return crTime;
	}
	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}
	public String getRegPw() {
		return regPw;
	}
	public void setRegPw(String regPw) {
		this.regPw = regPw;
	}
	public String getRegPrefix() {
		return regPrefix;
	}
	public void setRegPrefix(String regPrefix) {
		this.regPrefix = regPrefix;
	}
	public String getRegNullUrl() {
		return regNullUrl;
	}
	public void setRegNullUrl(String regNullUrl) {
		this.regNullUrl = regNullUrl;
	}
	
	

}
