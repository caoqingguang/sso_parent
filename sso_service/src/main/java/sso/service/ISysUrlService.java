package sso.service;

import sso.entity.SysUrl;
import sso.util.framework.service.IBaseService;


public interface ISysUrlService extends IBaseService<SysUrl>{
	
	SysUrl  selectSysUrlByPid(Long pid);
}
