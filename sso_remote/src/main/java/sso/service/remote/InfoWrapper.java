package sso.service.remote;

import java.util.Date;
import java.util.List;

import sso.entity.Sys;
import sso.entity.SysUrl;
import sso.entity.User;

public class InfoWrapper {
	private Boolean can;
	private Date lastReq;
	private User user;
	private List<Sys> sysList;
	private List<SysUrl> urlList;
	public Boolean getCan() {
		return can;
	}
	public void setCan(Boolean can) {
		this.can = can;
	}
	public Date getLastReq() {
		return lastReq;
	}
	public void setLastReq(Date lastReq) {
		this.lastReq = lastReq;
	}
	public List<Sys> getSysList() {
		return sysList;
	}
	public void setSysList(List<Sys> sysList) {
		this.sysList = sysList;
	}
	public List<SysUrl> getUrlList() {
		return urlList;
	}
	public void setUrlList(List<SysUrl> urlList) {
		this.urlList = urlList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
