package sso.service.remote;

import java.util.Date;
import java.util.List;

import sso.entity.Sys;
import sso.entity.SysUrl;

public interface IAuthRemote {
	List<Sys> getSysListCan(String token,Date lastReqTime);
	List<SysUrl> getSysUrlListCan(String token,Date lastReqTime);
	List<Sys> getSysListCan(String token);
	List<SysUrl> getSysUrlListCan(String token);
	
	
}
