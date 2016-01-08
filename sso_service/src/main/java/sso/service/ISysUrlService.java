package sso.service;

import java.util.List;

import sso.entity.Sys;
import sso.entity.SysUrl;
import sso.util.framework.service.IBaseService;

import com.alibaba.fastjson.JSONArray;


public interface ISysUrlService extends IBaseService<SysUrl>{
	
	SysUrl  selectSysUrlByPid(Long pid);
	JSONArray	selectSysUrlTree(List<Sys> sysList);
	JSONArray selectSysUrlTreeWithSelect(Long sysId,Long roleId,boolean open);
	void updateRoleUrl(Long roleId,Long[] ids);
}
